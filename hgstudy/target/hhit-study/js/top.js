/**
 * Created by Administrator on 2016/12/22.
 */

$(document).ready(function () {
    $(".dropdown").mouseenter(function () {
        console.log("<<")
        $(this).find('.dropdown-menu').slideDown()
    })
    $(".dropdown").mouseleave(function () {
        console.log(">>")
        $(this).find('.dropdown-menu').hide()
    })
})