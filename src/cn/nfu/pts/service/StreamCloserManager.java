package cn.nfu.pts.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;

public class StreamCloserManager {

	/**
	 * @description:close inputstream
	 * @version:v1.0
	 * @param is
	 */
	public static void closeInputStream(InputStream is){
		if(is != null){
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				is = null;
			}
		}
	}

	/**
	 * @description:close outputstream
	 * @version:v1.0
	 * @param os
	 */
	public static void closeOutputStream(OutputStream os){
		if(os != null){
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				os = null;
			}
		}
	}

	/**
	 * @description:close reader
	 * @version:v1.0
	 * @param reader
	 */
	public static void closeReader(Reader reader){
		if(reader != null){
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				reader = null;
			}
		}
	}

	/**
	 * @description:close urlconnection
	 * @version:v1.0
	 * @param uconn
	 */
	public static void closeUrlConnection(HttpURLConnection uconn){
		if (uconn != null) {
			uconn.disconnect();
			uconn = null;
		}
	}
}
