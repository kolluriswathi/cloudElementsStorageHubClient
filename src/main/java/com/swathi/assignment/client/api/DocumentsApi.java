package com.swathi.assignment.client.api;

import com.swathi.assignment.client.invoker.ApiClient;

import com.swathi.assignment.client.model.CloudFile;
import com.swathi.assignment.client.model.CloudLink;
import com.swathi.assignment.client.model.CloudStorage;
import org.joda.time.DateTime;
import java.io.File;
import com.swathi.assignment.client.model.Metadata;
import com.swathi.assignment.client.model.Pong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-22T09:41:00.238+05:30")
@Component("com.swathi.assignment.client.api.DocumentsApi")
public class DocumentsApi {
    private ApiClient apiClient;

    public DocumentsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DocumentsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Uploads a file to your endpoint cloud service. If the destination path includes directories that do not exist, they will be created.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @param file The file to be uploaded
     * @param size The size of the file in bytes (required only for SharePoint)
     * @param tags Tags associated with the file
     * @param description Description of the file
     * @param overwrite Overwrite the file if the file exists
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFile(String authorization, String path, File file, Long size, List<String> tags, String description, Boolean overwrite) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFile");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling createFile");
        }

        String path1 = UriComponentsBuilder.fromPath("/files").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "size", size));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase()), "tags[]", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "description", description));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "overwrite", overwrite));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        if (file != null)
            formParams.add("file", new FileSystemResource(file));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {
            "multipart/form-data"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Copies a file specified by a file path to another file path, leaving the original intact.  If the source file path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a file that already exists results in an error response.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @param body A CloudFile object representing the destination file. Path is required and no other fields are supported.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFileCopy(String authorization, String path, CloudFile body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFileCopy");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling createFileCopy");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling createFileCopy");
        }

        String path1 = UriComponentsBuilder.fromPath("/files/copy").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Copies a file associated with an ID from a specified file path to another file path, leaving the original intact.  If the source file associated with an ID does not exist an error response is returned.  If the destination path includes directories that do not exist they will be created.  Copying a file that already exists results in an error response.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param body A CloudFile object representing the destination file. Path is required
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFileCopy2(String authorization, String id, CloudFile body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFileCopy2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling createFileCopy2");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling createFileCopy2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}/copy").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Creates a new folder on your cloud service using its specified path.  Creation of the new folder goes through Cloud Elements.  If the destination path includes directories that do not exist they will be created.  Creating a folder that already exists results in an error response.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param body A CloudFile object with the fields to create. Valid values include path
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFolder(String authorization, CloudFile body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFolder");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling createFolder");
        }

        String path = UriComponentsBuilder.fromPath("/folders").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Copies a folder specified by a file path to another file path, leaving the original intact.  If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the existing folder (e.g. /myDirectory)
     * @param body A CloudFile object representing the destination folder. Path is required
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFolderCopy(String authorization, String path, CloudFile body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFolderCopy");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling createFolderCopy");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling createFolderCopy");
        }

        String path1 = UriComponentsBuilder.fromPath("/folders/copy").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Copies a folder associated with an ID specified by a file path to another file path, leaving the original intact. If the source path does not exist an error response is returned.  If the destination path includes directories that do not exist, they will be created.  Copying a folder that already exists results in an error response.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param body A CloudFile object representing the destination folder. Path is required
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile createFolderCopy2(String authorization, String id, CloudFile body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling createFolderCopy2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling createFolderCopy2");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling createFolderCopy2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/folders/{id}/copy").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a specific file associated with an ID from your cloud service using its specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param emptyTrash Whether or not the trash should be emptied
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteFileById(String authorization, String id, Boolean emptyTrash) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling deleteFileById");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteFileById");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "emptyTrash", emptyTrash));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a file from your cloud service by its specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @param emptyTrash Whether or not the trash should be emptied
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteFiles(String authorization, String path, Boolean emptyTrash) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling deleteFiles");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling deleteFiles");
        }

        String path1 = UriComponentsBuilder.fromPath("/files").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "emptyTrash", emptyTrash));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path1, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an entire folder associated with an ID from your cloud service.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param emptyTrash Whether or not the trash should be emptied
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteFolderById(String authorization, String id, Boolean emptyTrash) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling deleteFolderById");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteFolderById");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/folders/{id}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "emptyTrash", emptyTrash));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an entire folder from your cloud service by its specified path. The folder specified is deleted from your cloud service.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the folder (e.g. /myDirectory)
     * @param emptyTrash Whether or not the trash should be emptied
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteFolders(String authorization, String path, Boolean emptyTrash) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling deleteFolders");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling deleteFolders");
        }

        String path1 = UriComponentsBuilder.fromPath("/folders").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "emptyTrash", emptyTrash));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path1, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves a specific file associated with an ID from your cloud service from a specified path.  The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFileById(String authorization, String id) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFileById");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFileById");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves a single file from your cloud service from a specified path. The file is directly streamed from the cloud storage provider through Cloud Elements, and is not buffered to disk.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFiles(String authorization, String path) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFiles");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling getFiles");
        }

        String path1 = UriComponentsBuilder.fromPath("/files").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns a link that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @return CloudLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudLink getFilesLinks(String authorization, String path) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFilesLinks");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling getFilesLinks");
        }

        String path1 = UriComponentsBuilder.fromPath("/files/links").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudLink> returnType = new ParameterizedTypeReference<CloudLink>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Returns a link associated with an ID that can be used to download the specified file through Cloud Elements.  The link can be used to download the file without providing credentials.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @return CloudLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudLink getFilesLinks2(String authorization, String id) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFilesLinks2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFilesLinks2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}/links").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudLink> returnType = new ParameterizedTypeReference<CloudLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves the metadata from a single file on your cloud service from a specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFilesMetadata(String authorization, String path, Boolean isoDates) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFilesMetadata");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling getFilesMetadata");
        }

        String path1 = UriComponentsBuilder.fromPath("/files/metadata").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves specific metadata on a file associated with an ID from your cloud service using its specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFilesMetadata2(String authorization, String id, Boolean isoDates) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFilesMetadata2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFilesMetadata2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}/metadata").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get a list of CloudFiles that are contained in a specified folder on your cloud service specified by a path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the folder (e.g. /myDirectory)
     * @param fetchTags Whether or not to return the tags for the files in the folder
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @param pageSize The page size for pagination, which defaults to 200 if not supplied
     * @param page The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
     * @param nextPage The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60;
     * @return List&lt;CloudFile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CloudFile> getFoldersContents(String authorization, String path, Boolean fetchTags, Boolean isoDates, Long pageSize, Long page, String nextPage) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFoldersContents");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling getFoldersContents");
        }

        String path1 = UriComponentsBuilder.fromPath("/folders/contents").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fetchTags", fetchTags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPage", nextPage));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<CloudFile>> returnType = new ParameterizedTypeReference<List<CloudFile>>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves a list of CloudFiles that are contained in a specified folder associated with an ID on your cloud service via a specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param fetchTags Whether or not to return the tags for the files in the folder
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @param pageSize The page size for pagination, which defaults to 200 if not supplied
     * @param page The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
     * @param nextPage The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60;
     * @return List&lt;CloudFile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CloudFile> getFoldersContents2(String authorization, String id, Boolean fetchTags, Boolean isoDates, Long pageSize, Long page, String nextPage) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFoldersContents2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFoldersContents2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/folders/{id}/contents").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fetchTags", fetchTags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPage", nextPage));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<CloudFile>> returnType = new ParameterizedTypeReference<List<CloudFile>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves specific metadata on a folder from your cloud service using its specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the folder (e.g. /myDirectory)
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFoldersMetadata(String authorization, String path, Boolean isoDates) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFoldersMetadata");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling getFoldersMetadata");
        }

        String path1 = UriComponentsBuilder.fromPath("/folders/metadata").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves specific metadata on a folder associated with an ID from your cloud service using its specified path.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param isoDates Optional query parameter to return the created and modified date/time in ISO8601 format.
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile getFoldersMetadata2(String authorization, String id, Boolean isoDates) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getFoldersMetadata2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFoldersMetadata2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/folders/{id}/metadata").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "isoDates", isoDates));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Ping the Element to confirm that the Hub element has a heartbeat.  If the Element does not have a heartbeat, an error message will be returned.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @return Pong
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Pong getPing(String authorization) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getPing");
        }

        String path = UriComponentsBuilder.fromPath("/ping").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Pong> returnType = new ParameterizedTypeReference<Pong>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Performs a text search of file names and directory names.  The content of files is not searched.  The search uses substring matching so searching for \&quot;exam\&quot; will match on \&quot;example.txt\&quot;.  Subdirectories are also searched.  The search returns a list of CloudFiles that match search parameters.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the folder to start searching from (e.g. /myDirectory)
     * @param text Text in the file or folder name
     * @param startDate The start date (based on the created date of the file or folder) if used, end date is required
     * @param endDate The end date (based on the created date of the file or folder) if used, start date is required
     * @param tags Any tags associated with the files (not applicable to folders)
     * @param pageSize The page size for pagination, which defaults to 200 if not supplied
     * @param page The start page for pagination, which defaults to 1 if not supplied. This parameter will be deprecated on Dec 31st 2018, use nextPage parameter to get the next page
     * @param nextPage The next page cursor, taken from the response header: &#x60;elements-next-page-token&#x60;
     * @return List&lt;CloudFile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CloudFile> getSearch(String authorization, String path, String text, DateTime startDate, DateTime endDate, List<String> tags, Long pageSize, Long page, String nextPage) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getSearch");
        }

        String path1 = UriComponentsBuilder.fromPath("/search").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "text", text));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startDate", startDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endDate", endDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase()), "tags[]", tags));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pageSize", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextPage", nextPage));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<CloudFile>> returnType = new ParameterizedTypeReference<List<CloudFile>>() {};
        return apiClient.invokeAPI(path1, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Retrieves the amount of storage available on your cloud service account.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @return CloudStorage
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudStorage getStorage(String authorization) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling getStorage");
        }

        String path = UriComponentsBuilder.fromPath("/storage").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudStorage> returnType = new ParameterizedTypeReference<CloudStorage>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a file&#39;s metadata (tags and path) associated with a path.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the file (e.g. /myDirectory/myFile.txt)
     * @param body A Metadata object with the fields to update. Valid values include path and tags
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile updateFilesMetadata(String authorization, String path, Metadata body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling updateFilesMetadata");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling updateFilesMetadata");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateFilesMetadata");
        }

        String path1 = UriComponentsBuilder.fromPath("/files/metadata").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a file&#39;s metadata (tags and path) associated with an ID.  For example, if you had a document that was tagged as operations but needed to be tagged as legal, then you would perform a PATCH to update the tag using the tags JSON array field. The PATCH method can update the name or directory of a file as well as move a file by using the path JSON field. You cannot update the size of a file.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The file ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param body A Metadata object with the fields to update. Valid values include path and tags
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile updateFilesMetadata2(String authorization, String id, Metadata body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling updateFilesMetadata2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateFilesMetadata2");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateFilesMetadata2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/files/{id}/metadata").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a folder&#39;s metadata (path) associated with its path.  For example, if you had a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path. The PATCH method can update the name or directory path of a folder also by using the path JSON field. You cannot update the size of a folder.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param path The full path to the existing folder (e.g. /myDirectory)
     * @param body A Metadata object with the field to update. Valid values include path
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile updateFoldersMetadata(String authorization, String path, Metadata body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling updateFoldersMetadata");
        }

        // verify the required parameter 'path' is set
        if (path == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'path' when calling updateFoldersMetadata");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateFoldersMetadata");
        }

        String path1 = UriComponentsBuilder.fromPath("/folders/metadata").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "path", path));

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path1, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a folder&#39;s metadata (path) associated with an ID.  For example, if you had the ID of a folder that was located in the operations directory, but needed to be moved into the legal directory, then you would perform a PATCH using the path JSON field to update the path.  The PATCH method can update the name or directory of a folder also by using the path JSON field. You cannot update the size of a folder.
     *
     * <p><b>200</b> - OK - Everything worked as expected
     * <p><b>400</b> - Bad Request - Often due to a missing request parameter
     * <p><b>401</b> - Unauthorized - An invalid element token, user secret and/or org secret provided
     * <p><b>403</b> - Forbidden - Access to the resource by the provider is forbidden
     * <p><b>404</b> - Not found - The requested resource is not found
     * <p><b>405</b> - Method not allowed - Incorrect HTTP verb used, e.g., GET used when POST expected
     * <p><b>406</b> - Not acceptable - The response content type does not match the &#39;Accept&#39; header value
     * <p><b>409</b> - Conflict - If a resource being created already exists
     * <p><b>415</b> - Unsupported media type - The server cannot handle the requested Content-Type
     * <p><b>500</b> - Server error - Something went wrong on the Cloud Elements server
     * <p><b>502</b> - Provider server error - Something went wrong on the Provider or Endpoint&#39;s server
     * @param authorization The authorization tokens. The format for the header value is &#39;Element &amp;lt;token&amp;gt;, User &amp;lt;user secret&amp;gt;&#39;
     * @param id The folder ID. For Sharepoint and Dropbox, this is the double URL-encoded path of the file. In this case, the ID must still be URL-encoded on the request, either automatically (e.g. Swagger), or programmatically if the client doesn&#39;t take care of it.
     * @param body A Metadata object with the field to update. Valid values include path
     * @return CloudFile
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CloudFile updateFoldersMetadata2(String authorization, String id, Metadata body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'authorization' is set
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authorization' when calling updateFoldersMetadata2");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateFoldersMetadata2");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateFoldersMetadata2");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/folders/{id}/metadata").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (authorization != null)
        headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CloudFile> returnType = new ParameterizedTypeReference<CloudFile>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
