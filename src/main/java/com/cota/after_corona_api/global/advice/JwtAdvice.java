package com.cota.after_corona_api.global.advice;

import com.cota.after_corona_api.global.annotation.WithJwtAdvice;
import com.cota.after_corona_api.global.error.ErrorCode;
import com.cota.after_corona_api.global.error.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = WithJwtAdvice.class)
public class JwtAdvice {
    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<ErrorResponse> handleUnsupportedJwtException(UnsupportedJwtException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        ErrorCode.MALFORMED_JWT,
                        "지원하지 않는 JWT 토큰 형식입니다!",
                        e.getMessage()
                ));
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ErrorResponse> handleMalformedJwtException(MalformedJwtException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        ErrorCode.MALFORMED_JWT,
                        "잘못된 JWT 토큰 형식입니다!",
                        e.getMessage()
                ));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> handleExpiredJwtException(ExpiredJwtException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        ErrorCode.EXPIRED_JWT_TOKEN,
                        "이미 만료된 JWT 토큰입니다!",
                        e.getMessage()
                ));
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorResponse> handleSignatureException(SignatureException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        ErrorCode.WRONG_SIGNATURE_JWT,
                        "잘못된 JWT 서명입니다!",
                        e.getMessage()
                ));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        ErrorCode.JWT_TOKEN_NOT_FOUND,
                        "JWT 토큰을 찾을 수 없습니다!",
                        e.getMessage()
                ));
    }
}
