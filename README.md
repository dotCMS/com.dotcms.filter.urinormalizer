# Uri Normalizer
Normalized URis before serving them

This plugin normalized a request.uri before the request comes into dotCMS, which then allows the remaining dotCMS interceptors, filters and permissioned folders to operate as expected and prevents directory traversal type attacks on folders under the dotCMS webapp/ROOT directory.

