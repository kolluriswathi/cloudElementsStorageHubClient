# swathi-assignment-api-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.swathi</groupId>
    <artifactId>swathi-assignment-api-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.swathi:swathi-assignment-api-client:0.0.1-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swathi-assignment-api-client-0.0.1-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.swathi.assignment.client.invoker.*;
import com.swathi.assignment.client.invoker.auth.*;
import com.swathi.assignment.client.model.*;
import com.swathi.assignment.client.api.DocumentsApi;

import java.io.File;
import java.util.*;

public class DocumentsApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://staging.cloud-elements.com/elements/api-v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DocumentsApi* | [**createFile**](docs/DocumentsApi.md#createFile) | **POST** /files | Uploads a file to your endpoint cloud service. If the destination path includes directories that do not exist, they will be created.
*DocumentsApi* | [**createFileCopy**](docs/DocumentsApi.md#createFileCopy) | **POST** /files/copy | Copies a file specified by a file path to another file path, leaving the original intact.  If the source file path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a file that already exists results in an error response.
*DocumentsApi* | [**createFileCopy2**](docs/DocumentsApi.md#createFileCopy2) | **POST** /files/{id}/copy | Copies a file associated with an ID from a specified file path to another file path, leaving the original intact.  If the source file associated with an ID does not exist an error response is returned.  If the destination path includes directories that do not exist they will be created.  Copying a file that already exists results in an error response.
*DocumentsApi* | [**createFolder**](docs/DocumentsApi.md#createFolder) | **POST** /folders | Creates a new folder on your cloud service using its specified path.  Creation of the new folder goes through Cloud Elements.  If the destination path includes directories that do not exist they will be created.  Creating a folder that already exists results in an error response.
*DocumentsApi* | [**createFolderCopy**](docs/DocumentsApi.md#createFolderCopy) | **POST** /folders/copy | Copies a folder specified by a file path to another file path, leaving the original intact.  If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.
*DocumentsApi* | [**createFolderCopy2**](docs/DocumentsApi.md#createFolderCopy2) | **POST** /folders/{id}/copy | Copies a folder associated with an ID specified by a file path to another file path, leaving the original intact. If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a folder that already exists results in an error response.
*DocumentsApi* | [**deleteFileById**](docs/DocumentsApi.md#deleteFileById) | **DELETE** /files/{id} | Deletes a specific file associated with an ID from your cloud service using its specified path.
*DocumentsApi* | [**deleteFiles**](docs/DocumentsApi.md#deleteFiles) | **DELETE** /files | Deletes a file from your cloud service by its specified path.
*DocumentsApi* | [**deleteFolderById**](docs/DocumentsApi.md#deleteFolderById) | **DELETE** /folders/{id} | Deletes an entire folder associated with an ID from your cloud service.
*DocumentsApi* | [**deleteFolders**](docs/DocumentsApi.md#deleteFolders) | **DELETE** /folders | Deletes an entire folder from your cloud service by its specified path. The folder specified is deleted from your cloud service.
*DocumentsApi* | [**getFileById**](docs/DocumentsApi.md#getFileById) | **GET** /files/{id} | Retrieves a specific file associated with an ID from your cloud service from a specified path.  The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
*DocumentsApi* | [**getFiles**](docs/DocumentsApi.md#getFiles) | **GET** /files | Retrieves a single file from your cloud service from a specified path. The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
*DocumentsApi* | [**getFilesLinks**](docs/DocumentsApi.md#getFilesLinks) | **GET** /files/links | Returns a link that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
*DocumentsApi* | [**getFilesLinks2**](docs/DocumentsApi.md#getFilesLinks2) | **GET** /files/{id}/links | Returns a link associated with an ID that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
*DocumentsApi* | [**getFilesMetadata**](docs/DocumentsApi.md#getFilesMetadata) | **GET** /files/metadata | Retrieves the metadata from a single file on your cloud service from a specified path.
*DocumentsApi* | [**getFilesMetadata2**](docs/DocumentsApi.md#getFilesMetadata2) | **GET** /files/{id}/metadata | Retrieves specific metadata on a file associated with an ID from your cloud service using its specified path.
*DocumentsApi* | [**getFoldersContents**](docs/DocumentsApi.md#getFoldersContents) | **GET** /folders/contents | Get a list of CloudFiles that are contained in a specified folder on your cloud service specified by a path.
*DocumentsApi* | [**getFoldersContents2**](docs/DocumentsApi.md#getFoldersContents2) | **GET** /folders/{id}/contents | Retrieves a list of CloudFiles that are contained in a specified folder associated with an ID on your cloud service via a specified path.
*DocumentsApi* | [**getFoldersMetadata**](docs/DocumentsApi.md#getFoldersMetadata) | **GET** /folders/metadata | Retrieves specific metadata on a folder from your cloud service using its specified path.
*DocumentsApi* | [**getFoldersMetadata2**](docs/DocumentsApi.md#getFoldersMetadata2) | **GET** /folders/{id}/metadata | Retrieves specific metadata on a folder associated with an ID from your cloud service using its specified path.
*DocumentsApi* | [**getPing**](docs/DocumentsApi.md#getPing) | **GET** /ping | Ping the Element to confirm that the Hub element has a heartbeat.  If the Element does not have a heartbeat, an error message will be returned.
*DocumentsApi* | [**getSearch**](docs/DocumentsApi.md#getSearch) | **GET** /search | Performs a text search of file names and directory names.  The content of files is not searched.  The search uses substring matching so searching for \&quot;exam\&quot; will match on \&quot;example.txt\&quot;.  Subdirectories are also searched.  The search returns a list of CloudFiles that match search parameters.
*DocumentsApi* | [**getStorage**](docs/DocumentsApi.md#getStorage) | **GET** /storage | Retrieves the amount of storage available on your cloud service account.
*DocumentsApi* | [**updateFilesMetadata**](docs/DocumentsApi.md#updateFilesMetadata) | **PATCH** /files/metadata | Update a file&#39;s metadata (tags and path) associated with a path.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
*DocumentsApi* | [**updateFilesMetadata2**](docs/DocumentsApi.md#updateFilesMetadata2) | **PATCH** /files/{id}/metadata | Update a file&#39;s metadata (tags and path) associated with an ID.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
*DocumentsApi* | [**updateFoldersMetadata**](docs/DocumentsApi.md#updateFoldersMetadata) | **PATCH** /folders/metadata | Update a folder&#39;s metadata (path) associated with its path.  For example, if you had a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path. The PATCH method can update the name or directory path of a folder also by using the path JSON field. You cannot update the size of a folder.
*DocumentsApi* | [**updateFoldersMetadata2**](docs/DocumentsApi.md#updateFoldersMetadata2) | **PATCH** /folders/{id}/metadata | Update a folder&#39;s metadata (path) associated with an ID.  For example, if you had the ID of a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path.  The PATCH method can update the name or directory of a folder also by using the path JSON field. You cannot update the size of a folder.


## Documentation for Models

 - [BulkLoad](docs/BulkLoad.md)
 - [BulkQuery](docs/BulkQuery.md)
 - [BulkStatus](docs/BulkStatus.md)
 - [CloudFile](docs/CloudFile.md)
 - [CloudLink](docs/CloudLink.md)
 - [CloudStorage](docs/CloudStorage.md)
 - [Metadata](docs/Metadata.md)
 - [ModelDate](docs/ModelDate.md)
 - [Pong](docs/Pong.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@cloud-elements.com

