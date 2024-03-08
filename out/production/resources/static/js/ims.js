
/*
 * 금일 날짜
 * */
function getToday(){
    let date = new Date();
    let year  = date.getFullYear();
    let month = date.getMonth() + 1;
    let day   = date.getDate();

    if (("" + month).length == 1) { month = "0" + month; }
    if (("" + day).length   == 1) { day   = "0" + day;   }

    return year+"-"+month+"-"+day;
}
/*
 * 전일 날짜
 * */
function getYesterday(){
    let nowdate = new Date();
    let yesdate = nowdate.getTime() - (1 * 24 * 60 * 60 * 1000);
    nowdate.setTime(yesdate);

    let year  = nowdate.getFullYear();
    let month = nowdate.getMonth() + 1;
    let day   = nowdate.getDate();

    if (("" + month).length == 1) { month = "0" + month; }
    if (("" + day).length   == 1) { day   = "0" + day;   }

    return year+"-"+month+"-"+day;
}
/*
 * 금일 날짜 - 없음
 * */
function getSimpleToday(){
    let date = new Date();
    let year  = date.getFullYear();
    let month = date.getMonth() + 1;
    let day   = date.getDate();

    if (("" + month).length == 1) { month = "0" + month; }
    if (("" + day).length   == 1) { day   = "0" + day;   }

    return year+""+month+""+day;
}
/*
 * Seconds To HH:mm:ss
 * */
function SecToHHmmss(m) {
    let fm = [
        Math.floor(m / 3600),
        Math.floor(m / 60) % 60,
        Math.floor(m) % 60
    ];
    return $.map(fm, function(v, i) { return ((v < 10) ? '0' : '') + v; }).join(':');
}

function jqXHR_Process(jqXHR){
    if (jqXHR.status === 901) {
        location.replace("/ims/login.do");

    }else if (jqXHR.status === 902) {
        console.log(jqXHR.responseText);
        alert("처리시 오류가 발생하였습니다.");
        return false;
    }
    else if (jqXHR.status === 404)
    {
        alert("페이지가 존재하지 않습니다.");
        return false;
    }
    else if (jqXHR.status === 500)
    {
        alert("처리시 오류가 발생하였습니다."); // 시스템에 문제가 발생하였습니다. 관리자에게 문의하세요.
        return false;
    }
}
$(document).ready(function() {
    const controls = {
        leftArrow: '<i class="fal fa-angle-left" style="font-size: 1.25rem"></i>',
        rightArrow: '<i class="fal fa-angle-right" style="font-size: 1.25rem"></i>'
    }

    $(".datepicker").val(getToday()); //오늘날짜 기본
    //$("#edate").val(getToday()); //오늘날짜 기본
    $('.datepicker').attr('readonly','readonly');

    $('.datepicker').datepicker({
            orientation: "bottom left",
            todayHighlight: true,
            autoclose: true,
            format: "yyyy-mm-dd"
    }).on("changeDate", function(e) {
    });
});