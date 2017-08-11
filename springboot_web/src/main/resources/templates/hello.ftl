
<!DOCTYPE html>
<html lang="en"> 
<body> 
    welcome ${greeting}  to freemarker!
    <@spring.message "product.detail.dangerours_cargo"/>
   ${encodeURL("好吧")}===${longToDate(123112212)}===========
    ${baseUrl}  ===${mainSiteUrl}====${g_lan}==${myRootPath}
</body> 
</html>