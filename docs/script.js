var list = document.getElementById('list')

window.onload = function (){
    var getAllTodo = 'http://10.120.74.130:8084/api/v1/todo-api/todo'
    //ajax 를 통해 해당 childTag 를 가진 모든 포스트를 불러온다
    $.ajax({
        method : 'GET',
        url : getAllTodo,
        dataType:"json",
        success:function(data) {
            data.forEach(element => {
                var title = element.message;
                var desc = element.description;

                var li = document.createElement('li')
                if(desc == null) desc = "";
                li.innerHTML = title + '<br>' + desc
                list.appendChild(li)
            });
        },
        error:function(a, b, c) {
            console.log(a, b, c)
        }

    })
}
