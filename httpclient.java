public class tutorial {

	// instantiating the HttpClient
	HttpClient client = new HttpClient();

	// creating a method
	// org.apache.commons.httpclient.methods
	HttpMethod method = new GetMethod("http://WWW.eCollege.COM/");

	// execute the method
	// set per default
	client.getParams().setParameter(HttpMethod.Params.RETRY_HANDER, new DefaultHttpMethodRetryHandler());

	// method recovery
	// customize the default retry handler - only use retry w/ idempotent operations; GET, not with POST or PUT.
	DefaultMethodRetryHandler retryHandler = new DefaultMethodRetryHandler(10, true);
	client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, retryHandler);

	// read the response
	byte[] responseBody = method.getResponseBody();

	// release the connection - ALWAYS DO THIS
	method.releaseConnection();

	// deal with the response
	System.out.println(new String(responseBody));

	// final source code - see other file...
}
	
