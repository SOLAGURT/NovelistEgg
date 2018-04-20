package main.com.ensemblebox.novelistegg



class Base64Encoder(imagePath: String) {

/*Javaのテストコード

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.net.URL;

public class Base64Example {
	public static void main(String[] args) throws Exception {

 		try {
 			final URL url =new URL("http://fujifilm.jp/personal/digitalcamera/x/fujinon_lens_xf16mmf14_r_wr/sample_images/img/index/ff_xf16mmf14_r_wr_005.JPG");
 			InputStream is = new BufferedInputStream(url.openStream());

 			byte[] bytes = toByteArray(is);

			String base64 = Base64.getEncoder().encodeToString(bytes);
 			System.out.println("<img src=\"data:image/jpeg;base64," + base64 + "\"/>");
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 	}

 	public static byte[] toByteArray(InputStream is) throws IOException {

 		ByteArrayOutputStream output = new ByteArrayOutputStream(1000000);

 		try {

 			byte[] b = new byte[4096];
 			int n = 0;

 			while ((n = is.read(b)) != -1) {
 				output.write(b, 0, n);
 			}

 		return output.toByteArray();

 		} finally {
 			output.close();
 		}
 	}
}


 */
}