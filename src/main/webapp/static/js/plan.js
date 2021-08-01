function createRw() {
    $('#rwDialog').modal('show');
}

function starPriority(paramNum) {
    setStar(paramNum, '#starPriority', 'star');
    $('#plan_priority').val(paramNum);
}

function starComplexity(paramNum) {
    setStar(paramNum, '#starComplexity', 'star');
    $('#plan_complexity').val(paramNum);
}

function starMoodIndex(paramNum) {
    setStar(paramNum, '#starMoodIndex', 'star');
    $('#memo_mood_index').val(paramNum);
}

function starStressIndex(paramNum) {
    setStar(paramNum, '#starStressIndex', 'star');
    $('#memo_stress_index').val(paramNum);
}

function setStar(paramNum, id, shape) {
    for (let i = 1; i <= 5; i++) {
        $(id + i).removeClass('glyphicon-' + shape);
        $(id + i).addClass('glyphicon-' + shape + '-empty');
    }
    for (let i = 1; i <= 5; i++) {
        $(id + i).removeClass('glyphicon-' + shape + '-empty');
        $(id + i).addClass('glyphicon-' + shape);
    }
}

function formSubmit(paramId) {
    $(paramId).submit();
}

function showMessage(paramId) {
    let content = $('#' + paramId).text();
    $('#msgContent').html(content);
    $('#msgDialog').modal('show');
}

function goPage(flag) {
    if (flag === 'prev') {
        let current = $('#currentPage').text();
        if (current !== '1') {
            $.ajax({
                type: 'GET',
                url: basePath + '/getContent?page=' + (Number(current) - 1),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        innerContentBody(data);
                    }
                }
            })
        } else {
            alert('已经是第一页！');
        }
    } else if (flag === 'next') {
        let current = $('#currentPage').text();
        if (lastPage !== Number(current)) {
            $.ajax({
                type: 'GET',
                url: basePath + '/getContent?page=' + (Number(current) + 1),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        innerContentBody(data);
                    }
                }
            })
        } else {
            alert('已经是最后一页！')
        }
    }
}

function goPageHC(flag) {
    if (flag === 'prev') {
        let current = $('#currentPage').text();
        if (current !== '1') {
            $.ajax({
                type: 'GET',
                url: basePath + '/planGoAll?page=' + (Number(current) - 1),
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        innerContentBody(data);
                    }
                }
            })
        } else {
            alert('已经是第一页！');
        }
    } else if (flag === 'next') {
        let current = $("#currentPage").text();
        if (lastPage !== Number(current)) {
            $.ajax({
                type: "GET",
                url: basePath + "/planGoAll?page=" + (Number(current) + 1),
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        innerContentBody(data);
                    }
                }
            });
        } else {
            alert("已经是最后一页了！");
        }
    }
}

// ajax返回的数据插入表格内部
function innerContentBody(data) {
    $('#contentBody').empty();
    let html = '';
    let planWork = data.data;
    for (let i = 0; i < planWork.length; i++) {
        // html += '<tr><td>'
        //     + planWork[i]
        //     + '</td>'
        //     + '</tr>'
        // TODO finish this later...
        console.log(planWork[i]);
    }
}