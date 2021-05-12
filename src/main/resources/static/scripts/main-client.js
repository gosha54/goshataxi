$(document).ready(function () {
    $(".tgl-ru").click(function () {
        $('.tgl-ru').toggleClass("lang-toggle-on");
        $('.tgl-en').toggleClass("lang-toggle-on");

    });
    $(".tgl-en").click(function () {
        $('.tgl-en').toggleClass("lang-toggle-on");
        $('.tgl-ru').toggleClass("lang-toggle-on");
    });
    $('a[href^="#"], a[href^="."]').click(function () { // если в href начинается с # или ., то ловим клик
        var scroll_el = $(this).attr('href'); // возьмем содержимое атрибута href
        if ($(scroll_el).length != 0) { // проверим существование элемента чтобы избежать ошибки
            $('html, body').animate({ scrollTop: $(scroll_el).offset().top - 70 }, 500); // анимируем скроолинг к элементу scroll_el
        }
        return false; // выключаем стандартное действие
    });
    $(".numbers, .numbers a").click(function () {
        $('.dd-numbers').toggleClass("show-block");
        var NavIsHide = $('.dd-numbers').hasClass("show-block");
        if (NavIsHide) {
            $('#nav-sections').collapse('hide')
        }
        

    });
    $(".numbers, .numbers a").blur(function () {
        $('.dd-numbers').removeClass("show-block");
    });
    $('#nav-btn').click(function () {
        var isNavCollapsed = $('#nav-btn').hasClass("collapsed");
        if (isNavCollapsed) {
            $('.dd-numbers').removeClass("show-block");
        }
    })
        
});
