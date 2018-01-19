/**
 * Created by ycw on 2016/12/30.
 */
$(document).ready(function () {
    $("#ios-course").show()
    $("#ios-title").mouseenter(function () {
        $(".course").hide()
        $("#ios-course").show()
        $("#ios-title").css({'background-color':'#537585'})
    })
    $("#ios-title").mouseleave(function () {
        $("#ios-title").css({'background-color':'white'})
    })
    $("#ios-title").click(function () {
        location.href = "../html/course_details.html"
    })
    $("#java-title").mouseenter(function () {
        $(".course").hide()
        $("#java-course").show()
        $("#java-title").css({'background-color':'#537585'})
    })
    $("#java-title").mouseleave(function () {
        $("#java-title").css({'background-color':'white'})
    })
    $("#java-title").click(function () {
        location.href = "../html/course_details.html"
    })
    $("#c-title").mouseenter(function () {
        $(".course").hide()
        $("#c-course").show()
        $("#c-title").css({'background-color':'#537585'})
    })
    $("#c-title").mouseleave(function () {
        $("#c-title").css({'background-color':'white'});
    })
    $("#c-title").click(function () {
        location.href = "../html/course_details.html"
    })
    $("#python-title").mouseenter(function () {
        $(".course").hide();
        $("#python-course").show()
        $("#python-title").css({'background-color':'#537585'})
    })
    $("#python-title").mouseleave(function () {
        $("#python-title").css({'background-color':'white'});
    })
    $("#python-title").click(function () {
        location.href = "../html/course_details.html"
    })
    $("#jsp-title").mouseenter(function () {
        $(".course").hide();
        $("#jsp-course").show()
        $("#jsp-title").css({'background-color':'#537585'})
    })
    $("#jsp-title").mouseleave(function () {
        $("#jsp-title").css({'background-color':'white'});
    })
    $("#jsp-title").click(function () {
        location.href = "../html/course_details.html"
    })
})