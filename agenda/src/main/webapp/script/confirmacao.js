/**
 * 
 */
jQuery(function(){
    var link=jQuery("a.excluir");
    var tela=jQuery("div.tela");
    var cancelar=jQuery("div.tela a");

    tela.hide();

    link.on("click",function(){
        tela.toggle();
    });

    cancelar.on("click",function(){
        tela.hide();
    })
});