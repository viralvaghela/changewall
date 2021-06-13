import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

class ChangeWall {

	public static void main(String s[]) throws IOException, InterruptedException {
		final String client_id = "uauRb7EuwrSRR9S0LRxIUPBGvqzUFGQvJbv7hXGK0A4";
		final String BASE_URL = "https://api.unsplash.com/";
		BufferedImage image = null;

		URL url = new URL(BASE_URL + "/photos/random?client_id=" + client_id);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		System.out.print(status);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		// System.out.print(content);

		/// save image

		try {

			URL imgurl = new URL(
					"https://images.unsplash.com/photo-1622295023576-e4fb6e9e8ba2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwyMzkyNjV8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2MDI1OTg&ixlib=rb-1.2.1&q=80&w=400");
			// read the url
			image = ImageIO.read(imgurl);

			ImageIO.write(image, "png", new File("/home/vrl/Desktop/changewall/img.jpg"));

			// for jpg
			// ImageIO.write(image, "jpg", new File("/tmp/have_a_question.jpg"));
			Process p = Runtime.getRuntime().exec("ls");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		in.close();
	}

}
