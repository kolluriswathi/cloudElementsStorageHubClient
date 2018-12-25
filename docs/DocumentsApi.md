# DocumentsApi

All URIs are relative to *https://staging.cloud-elements.com/elements/api-v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFile**](DocumentsApi.md#createFile) | **POST** /files | Uploads a file to your endpoint cloud service. If the destination path includes directories that do not exist, they will be created.
[**createFileCopy**](DocumentsApi.md#createFileCopy) | **POST** /files/copy | Copies a file specified by a file path to another file path, leaving the original intact.  If the source file path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a file that already exists results in an error response.
[**createFileCopy2**](DocumentsApi.md#createFileCopy2) | **POST** /files/{id}/copy | Copies a file associated with an ID from a specified file path to another file path, leaving the original intact.  If the source file associated with an ID does not exist an error response is returned.  If the destination path includes directories that do not exist they will be created.  Copying a file that already exists results in an error response.
[**createFolder**](DocumentsApi.md#createFolder) | **POST** /folders | Creates a new folder on your cloud service using its specified path.  Creation of the new folder goes through Cloud Elements.  If the destination path includes directories that do not exist they will be created.  Creating a folder that already exists results in an error response.
[**createFolderCopy**](DocumentsApi.md#createFolderCopy) | **POST** /folders/copy | Copies a folder specified by a file path to another file path, leaving the original intact.  If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.
[**createFolderCopy2**](DocumentsApi.md#createFolderCopy2) | **POST** /folders/{id}/copy | Copies a folder associated with an ID specified by a file path to another file path, leaving the original intact. If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a folder that already exists results in an error response.
[**deleteFileById**](DocumentsApi.md#deleteFileById) | **DELETE** /files/{id} | Deletes a specific file associated with an ID from your cloud service using its specified path.
[**deleteFiles**](DocumentsApi.md#deleteFiles) | **DELETE** /files | Deletes a file from your cloud service by its specified path.
[**deleteFolderById**](DocumentsApi.md#deleteFolderById) | **DELETE** /folders/{id} | Deletes an entire folder associated with an ID from your cloud service.
[**deleteFolders**](DocumentsApi.md#deleteFolders) | **DELETE** /folders | Deletes an entire folder from your cloud service by its specified path. The folder specified is deleted from your cloud service.
[**getFileById**](DocumentsApi.md#getFileById) | **GET** /files/{id} | Retrieves a specific file associated with an ID from your cloud service from a specified path.  The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
[**getFiles**](DocumentsApi.md#getFiles) | **GET** /files | Retrieves a single file from your cloud service from a specified path. The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
[**getFilesLinks**](DocumentsApi.md#getFilesLinks) | **GET** /files/links | Returns a link that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
[**getFilesLinks2**](DocumentsApi.md#getFilesLinks2) | **GET** /files/{id}/links | Returns a link associated with an ID that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
[**getFilesMetadata**](DocumentsApi.md#getFilesMetadata) | **GET** /files/metadata | Retrieves the metadata from a single file on your cloud service from a specified path.
[**getFilesMetadata2**](DocumentsApi.md#getFilesMetadata2) | **GET** /files/{id}/metadata | Retrieves specific metadata on a file associated with an ID from your cloud service using its specified path.
[**getFoldersContents**](DocumentsApi.md#getFoldersContents) | **GET** /folders/contents | Get a list of CloudFiles that are contained in a specified folder on your cloud service specified by a path.
[**getFoldersContents2**](DocumentsApi.md#getFoldersContents2) | **GET** /folders/{id}/contents | Retrieves a list of CloudFiles that are contained in a specified folder associated with an ID on your cloud service via a specified path.
[**getFoldersMetadata**](DocumentsApi.md#getFoldersMetadata) | **GET** /folders/metadata | Retrieves specific metadata on a folder from your cloud service using its specified path.
[**getFoldersMetadata2**](DocumentsApi.md#getFoldersMetadata2) | **GET** /folders/{id}/metadata | Retrieves specific metadata on a folder associated with an ID from your cloud service using its specified path.
[**getPing**](DocumentsApi.md#getPing) | **GET** /ping | Ping the Element to confirm that the Hub element has a heartbeat.  If the Element does not have a heartbeat, an error message will be returned.
[**getSearch**](DocumentsApi.md#getSearch) | **GET** /search | Performs a text search of file names and directory names.  The content of files is not searched.  The search uses substring matching so searching for \&quot;exam\&quot; will match on \&quot;example.txt\&quot;.  Subdirectories are also searched.  The search returns a list of CloudFiles that match search parameters.
[**getStorage**](DocumentsApi.md#getStorage) | **GET** /storage | Retrieves the amount of storage available on your cloud service account.
[**updateFilesMetadata**](DocumentsApi.md#updateFilesMetadata) | **PATCH** /files/metadata | Update a file&#39;s metadata (tags and path) associated with a path.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
[**updateFilesMetadata2**](DocumentsApi.md#updateFilesMetadata2) | **PATCH** /files/{id}/metadata | Update a file&#39;s metadata (tags and path) associated with an ID.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
[**updateFoldersMetadata**](DocumentsApi.md#updateFoldersMetadata) | **PATCH** /folders/metadata | Update a folder&#39;s metadata (path) associated with its path.  For example, if you had a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path. The PATCH method can update the name or directory path of a folder also by using the path JSON field. You cannot update the size of a folder.
[**updateFoldersMetadata2**](DocumentsApi.md#updateFoldersMetadata2) | **PATCH** /folders/{id}/metadata | Update a folder&#39;s metadata (path) associated with an ID.  For example, if you had the ID of a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path.  The PATCH method can update the name or directory of a folder also by using the path JSON field. You cannot update the size of a folder.


<a name="createFile"></a>
# **createFile**
> CloudFile createFile(authorization, path, file, size, tags, description, overwrite)

Uploads a file to your endpoint cloud service. If the destination path includes directories that do not exist, they will be created.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
File file = new File("/path/to/file.txt"); // File | The file to be uploaded
Long size = 789L; // Long | The size of the file in bytes (required only for SharePoint)
List<String> tags = Arrays.asList("tags_example"); // List<String> | Tags associated with the file
String description = "description_example"; // String | Description of the file
Boolean overwrite = true; // Boolean | Overwrite the file if the file exists
try {
    CloudFile result = apiInstance.createFile(authorization, path, file, size, tags, description, overwrite);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |
 **file** | **File**| The file to be uploaded | [optional]
 **size** | **Long**| The size of the file in bytes (required only for SharePoint) | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| Tags associated with the file | [optional]
 **description** | **String**| Description of the file | [optional]
 **overwrite** | **Boolean**| Overwrite the file if the file exists | [optional]

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: Not defined

<a name="createFileCopy"></a>
# **createFileCopy**
> CloudFile createFileCopy(authorization, path, body)

Copies a file specified by a file path to another file path, leaving the original intact.  If the source file path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a file that already exists results in an error response.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
CloudFile body = new CloudFile(); // CloudFile | A CloudFile object representing the destination file. Path is required and no other fields are supported.
try {
    CloudFile result = apiInstance.createFileCopy(authorization, path, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFileCopy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |
 **body** | [**CloudFile**](CloudFile.md)| A CloudFile object representing the destination file. Path is required and no other fields are supported. |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createFileCopy2"></a>
# **createFileCopy2**
> CloudFile createFileCopy2(authorization, id, body)

Copies a file associated with an ID from a specified file path to another file path, leaving the original intact.  If the source file associated with an ID does not exist an error response is returned.  If the destination path includes directories that do not exist they will be created.  Copying a file that already exists results in an error response.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
CloudFile body = new CloudFile(); // CloudFile | A CloudFile object representing the destination file. Path is required
try {
    CloudFile result = apiInstance.createFileCopy2(authorization, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFileCopy2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **body** | [**CloudFile**](CloudFile.md)| A CloudFile object representing the destination file. Path is required |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createFolder"></a>
# **createFolder**
> CloudFile createFolder(authorization, body)

Creates a new folder on your cloud service using its specified path.  Creation of the new folder goes through Cloud Elements.  If the destination path includes directories that do not exist they will be created.  Creating a folder that already exists results in an error response.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
CloudFile body = new CloudFile(); // CloudFile | A CloudFile object with the fields to create. Valid values include path
try {
    CloudFile result = apiInstance.createFolder(authorization, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **body** | [**CloudFile**](CloudFile.md)| A CloudFile object with the fields to create. Valid values include path |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createFolderCopy"></a>
# **createFolderCopy**
> CloudFile createFolderCopy(authorization, path, body)

Copies a folder specified by a file path to another file path, leaving the original intact.  If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the existing folder (e.g. /myDirectory)
CloudFile body = new CloudFile(); // CloudFile | A CloudFile object representing the destination folder. Path is required
try {
    CloudFile result = apiInstance.createFolderCopy(authorization, path, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFolderCopy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the existing folder (e.g. /myDirectory) |
 **body** | [**CloudFile**](CloudFile.md)| A CloudFile object representing the destination folder. Path is required |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createFolderCopy2"></a>
# **createFolderCopy2**
> CloudFile createFolderCopy2(authorization, id, body)

Copies a folder associated with an ID specified by a file path to another file path, leaving the original intact. If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a folder that already exists results in an error response.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
CloudFile body = new CloudFile(); // CloudFile | A CloudFile object representing the destination folder. Path is required
try {
    CloudFile result = apiInstance.createFolderCopy2(authorization, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#createFolderCopy2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **body** | [**CloudFile**](CloudFile.md)| A CloudFile object representing the destination folder. Path is required |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteFileById"></a>
# **deleteFileById**
> deleteFileById(authorization, id, emptyTrash)

Deletes a specific file associated with an ID from your cloud service using its specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Boolean emptyTrash = true; // Boolean | Whether or not the trash should be emptied
try {
    apiInstance.deleteFileById(authorization, id, emptyTrash);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#deleteFileById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **emptyTrash** | **Boolean**| Whether or not the trash should be emptied | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteFiles"></a>
# **deleteFiles**
> deleteFiles(authorization, path, emptyTrash)

Deletes a file from your cloud service by its specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
Boolean emptyTrash = true; // Boolean | Whether or not the trash should be emptied
try {
    apiInstance.deleteFiles(authorization, path, emptyTrash);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#deleteFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |
 **emptyTrash** | **Boolean**| Whether or not the trash should be emptied | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteFolderById"></a>
# **deleteFolderById**
> deleteFolderById(authorization, id, emptyTrash)

Deletes an entire folder associated with an ID from your cloud service.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Boolean emptyTrash = true; // Boolean | Whether or not the trash should be emptied
try {
    apiInstance.deleteFolderById(authorization, id, emptyTrash);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#deleteFolderById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **emptyTrash** | **Boolean**| Whether or not the trash should be emptied | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="deleteFolders"></a>
# **deleteFolders**
> deleteFolders(authorization, path, emptyTrash)

Deletes an entire folder from your cloud service by its specified path. The folder specified is deleted from your cloud service.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the folder (e.g. /myDirectory)
Boolean emptyTrash = true; // Boolean | Whether or not the trash should be emptied
try {
    apiInstance.deleteFolders(authorization, path, emptyTrash);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#deleteFolders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the folder (e.g. /myDirectory) |
 **emptyTrash** | **Boolean**| Whether or not the trash should be emptied | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFileById"></a>
# **getFileById**
> CloudFile getFileById(authorization, id)

Retrieves a specific file associated with an ID from your cloud service from a specified path.  The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
try {
    CloudFile result = apiInstance.getFileById(authorization, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFileById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFiles"></a>
# **getFiles**
> CloudFile getFiles(authorization, path)

Retrieves a single file from your cloud service from a specified path. The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
try {
    CloudFile result = apiInstance.getFiles(authorization, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFilesLinks"></a>
# **getFilesLinks**
> CloudLink getFilesLinks(authorization, path)

Returns a link that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
try {
    CloudLink result = apiInstance.getFilesLinks(authorization, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFilesLinks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |

### Return type

[**CloudLink**](CloudLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFilesLinks2"></a>
# **getFilesLinks2**
> CloudLink getFilesLinks2(authorization, id)

Returns a link associated with an ID that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
try {
    CloudLink result = apiInstance.getFilesLinks2(authorization, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFilesLinks2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |

### Return type

[**CloudLink**](CloudLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFilesMetadata"></a>
# **getFilesMetadata**
> CloudFile getFilesMetadata(authorization, path, isoDates)

Retrieves the metadata from a single file on your cloud service from a specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
try {
    CloudFile result = apiInstance.getFilesMetadata(authorization, path, isoDates);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFilesMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFilesMetadata2"></a>
# **getFilesMetadata2**
> CloudFile getFilesMetadata2(authorization, id, isoDates)

Retrieves specific metadata on a file associated with an ID from your cloud service using its specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
try {
    CloudFile result = apiInstance.getFilesMetadata2(authorization, id, isoDates);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFilesMetadata2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFoldersContents"></a>
# **getFoldersContents**
> List&lt;CloudFile&gt; getFoldersContents(authorization, path, fetchTags, isoDates, pageSize, page, nextPage)

Get a list of CloudFiles that are contained in a specified folder on your cloud service specified by a path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the folder (e.g. /myDirectory)
Boolean fetchTags = true; // Boolean | Whether or not to return the tags for the files in the folder
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
Long pageSize = 789L; // Long | The page size for pagination, which defaults to 200 if not supplied
Long page = 789L; // Long | The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
String nextPage = "nextPage_example"; // String | The next page cursor, taken from the response header: `elements-next-page-token`
try {
    List<CloudFile> result = apiInstance.getFoldersContents(authorization, path, fetchTags, isoDates, pageSize, page, nextPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFoldersContents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the folder (e.g. /myDirectory) |
 **fetchTags** | **Boolean**| Whether or not to return the tags for the files in the folder | [optional]
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]
 **pageSize** | **Long**| The page size for pagination, which defaults to 200 if not supplied | [optional]
 **page** | **Long**| The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page | [optional]
 **nextPage** | **String**| The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60; | [optional]

### Return type

[**List&lt;CloudFile&gt;**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFoldersContents2"></a>
# **getFoldersContents2**
> List&lt;CloudFile&gt; getFoldersContents2(authorization, id, fetchTags, isoDates, pageSize, page, nextPage)

Retrieves a list of CloudFiles that are contained in a specified folder associated with an ID on your cloud service via a specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Boolean fetchTags = true; // Boolean | Whether or not to return the tags for the files in the folder
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
Long pageSize = 789L; // Long | The page size for pagination, which defaults to 200 if not supplied
Long page = 789L; // Long | The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
String nextPage = "nextPage_example"; // String | The next page cursor, taken from the response header: `elements-next-page-token`
try {
    List<CloudFile> result = apiInstance.getFoldersContents2(authorization, id, fetchTags, isoDates, pageSize, page, nextPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFoldersContents2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **fetchTags** | **Boolean**| Whether or not to return the tags for the files in the folder | [optional]
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]
 **pageSize** | **Long**| The page size for pagination, which defaults to 200 if not supplied | [optional]
 **page** | **Long**| The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page | [optional]
 **nextPage** | **String**| The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60; | [optional]

### Return type

[**List&lt;CloudFile&gt;**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFoldersMetadata"></a>
# **getFoldersMetadata**
> CloudFile getFoldersMetadata(authorization, path, isoDates)

Retrieves specific metadata on a folder from your cloud service using its specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the folder (e.g. /myDirectory)
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
try {
    CloudFile result = apiInstance.getFoldersMetadata(authorization, path, isoDates);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFoldersMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the folder (e.g. /myDirectory) |
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getFoldersMetadata2"></a>
# **getFoldersMetadata2**
> CloudFile getFoldersMetadata2(authorization, id, isoDates)

Retrieves specific metadata on a folder associated with an ID from your cloud service using its specified path.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Boolean isoDates = true; // Boolean | Optional query parameter to return the created and modified date/time in ISO8601 format.
try {
    CloudFile result = apiInstance.getFoldersMetadata2(authorization, id, isoDates);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getFoldersMetadata2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **isoDates** | **Boolean**| Optional query parameter to return the created and modified date/time in ISO8601 format. | [optional]

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getPing"></a>
# **getPing**
> Pong getPing(authorization)

Ping the Element to confirm that the Hub element has a heartbeat.  If the Element does not have a heartbeat, an error message will be returned.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
try {
    Pong result = apiInstance.getPing(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getPing");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |

### Return type

[**Pong**](Pong.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getSearch"></a>
# **getSearch**
> List&lt;CloudFile&gt; getSearch(authorization, path, text, startDate, endDate, tags, pageSize, page, nextPage)

Performs a text search of file names and directory names.  The content of files is not searched.  The search uses substring matching so searching for \&quot;exam\&quot; will match on \&quot;example.txt\&quot;.  Subdirectories are also searched.  The search returns a list of CloudFiles that match search parameters.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the folder to start searching from (e.g. /myDirectory)
String text = "text_example"; // String | Text in the file or folder name
DateTime startDate = new DateTime(); // DateTime | The start date (based on the created date of the file or folder) if used, end date is required
DateTime endDate = new DateTime(); // DateTime | The end date (based on the created date of the file or folder) if used, start date is required
List<String> tags = Arrays.asList("tags_example"); // List<String> | Any tags associated with the files (not applicable to folders)
Long pageSize = 789L; // Long | The page size for pagination, which defaults to 200 if not supplied
Long page = 789L; // Long | The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
String nextPage = "nextPage_example"; // String | The next page cursor, taken from the response header: `elements-next-page-token`
try {
    List<CloudFile> result = apiInstance.getSearch(authorization, path, text, startDate, endDate, tags, pageSize, page, nextPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the folder to start searching from (e.g. /myDirectory) | [optional]
 **text** | **String**| Text in the file or folder name | [optional]
 **startDate** | **DateTime**| The start date (based on the created date of the file or folder) if used, end date is required | [optional]
 **endDate** | **DateTime**| The end date (based on the created date of the file or folder) if used, start date is required | [optional]
 **tags** | [**List&lt;String&gt;**](String.md)| Any tags associated with the files (not applicable to folders) | [optional]
 **pageSize** | **Long**| The page size for pagination, which defaults to 200 if not supplied | [optional]
 **page** | **Long**| The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page | [optional]
 **nextPage** | **String**| The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60; | [optional]

### Return type

[**List&lt;CloudFile&gt;**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getStorage"></a>
# **getStorage**
> CloudStorage getStorage(authorization)

Retrieves the amount of storage available on your cloud service account.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
try {
    CloudStorage result = apiInstance.getStorage(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#getStorage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |

### Return type

[**CloudStorage**](CloudStorage.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateFilesMetadata"></a>
# **updateFilesMetadata**
> CloudFile updateFilesMetadata(authorization, path, body)

Update a file&#39;s metadata (tags and path) associated with a path.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the file (e.g. /myDirectory/myFile.txt)
Metadata body = new Metadata(); // Metadata | A Metadata object with the fields to update. Valid values include path and tags
try {
    CloudFile result = apiInstance.updateFilesMetadata(authorization, path, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#updateFilesMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the file (e.g. /myDirectory/myFile.txt) |
 **body** | [**Metadata**](Metadata.md)| A Metadata object with the fields to update. Valid values include path and tags |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateFilesMetadata2"></a>
# **updateFilesMetadata2**
> CloudFile updateFilesMetadata2(authorization, id, body)

Update a file&#39;s metadata (tags and path) associated with an ID.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Metadata body = new Metadata(); // Metadata | A Metadata object with the fields to update. Valid values include path and tags
try {
    CloudFile result = apiInstance.updateFilesMetadata2(authorization, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#updateFilesMetadata2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **body** | [**Metadata**](Metadata.md)| A Metadata object with the fields to update. Valid values include path and tags |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateFoldersMetadata"></a>
# **updateFoldersMetadata**
> CloudFile updateFoldersMetadata(authorization, path, body)

Update a folder&#39;s metadata (path) associated with its path.  For example, if you had a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path. The PATCH method can update the name or directory path of a folder also by using the path JSON field. You cannot update the size of a folder.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String path = "path_example"; // String | The full path to the existing folder (e.g. /myDirectory)
Metadata body = new Metadata(); // Metadata | A Metadata object with the field to update. Valid values include path
try {
    CloudFile result = apiInstance.updateFoldersMetadata(authorization, path, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#updateFoldersMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **path** | **String**| The full path to the existing folder (e.g. /myDirectory) |
 **body** | [**Metadata**](Metadata.md)| A Metadata object with the field to update. Valid values include path |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="updateFoldersMetadata2"></a>
# **updateFoldersMetadata2**
> CloudFile updateFoldersMetadata2(authorization, id, body)

Update a folder&#39;s metadata (path) associated with an ID.  For example, if you had the ID of a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path.  The PATCH method can update the name or directory of a folder also by using the path JSON field. You cannot update the size of a folder.

### Example
```java
// Import classes:
//import com.swathi.assignment.client.invoker.ApiException;
//import com.swathi.assignment.client.api.DocumentsApi;


DocumentsApi apiInstance = new DocumentsApi();
String authorization = "authorization_example"; // String | The authorization tokens. The format for the header value is 'Element &lt;token&gt;, User &lt;user secret&gt;'
String id = "id_example"; // String | The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn't take care of it.
Metadata body = new Metadata(); // Metadata | A Metadata object with the field to update. Valid values include path
try {
    CloudFile result = apiInstance.updateFoldersMetadata2(authorization, id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DocumentsApi#updateFoldersMetadata2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39; |
 **id** | **String**| The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it. |
 **body** | [**Metadata**](Metadata.md)| A Metadata object with the field to update. Valid values include path |

### Return type

[**CloudFile**](CloudFile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

