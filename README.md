# Uri Normalizer
Normalized URis before serving them, e.g.

https://demo.dotcms.com/testing/../index 

becomes

https://demo.dotcms.com/index 

This plugin normalizes the request.uri returned by `request.getRequestURI()` before the request comes into dotCMS, which then allows the remaining dotCMS interceptors, filters and permissioned folders to operate as expected and prevents directory traversal type attacks on folders which should be protected under the dotCMS webapp/ROOT directory.

This plugin was built against dotCMS 5.x and should work from 5.0 on up.
