public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodedImage decodedImage;
		ImageReader reader = null;
		String image = "image.gif";
		String format = image.substring(image.lastIndexOf('.')+1);
		if(format.equals("gif")) {
			reader = new GifReader(image);
		}
		
		decodedImage = reader.getDecodeImage();
		System.out.println(decodedImage);
		
		String image2 = "image.jpeg";
		String format2 = image2.substring(image2.lastIndexOf('.')+1);
		if(format2.equals("jpeg")) {
			reader = new JpegReader(image2);
		}
		
		decodedImage = reader.getDecodeImage();
		System.out.println(decodedImage);
	}

}
