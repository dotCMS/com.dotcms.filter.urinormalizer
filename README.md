# Uri Normalizer
Normalized URis before serving them, e.g.

https://demo.dotcms.com/testing/../index 

becomes

https://demo.dotcms.com/index 

This plugin normalizes the request.uri returned by `request.getRequestURI()` before the request comes into dotCMS, which then allows the remaining dotCMS interceptors, filters and permissioned folders to operate as expected and prevents directory traversal type attacks on folders which should be protected under the dotCMS webapp/ROOT directory.

This plugin was built against dotCMS 5.2.8 but should work from 5.0 on up.


To test that the filter is working, attempt to visit this url:

https://{yoursite}//html/portlet/ext/files/edit_text_inc.jsp

a 401 response indicates the code is working.
