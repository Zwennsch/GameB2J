package com.svenjava.puzzle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	BufferedImage src;
	static BufferedImage resizedImage;
	
	public ImageLoader(String source, int desiredWidth) {
		try {
			src = loadImage(source);
			int h = getNewHeight(src.getWidth(), src.getHeight(), desiredWidth);
			resizedImage = resizeImage(src, desiredWidth, h, BufferedImage.TYPE_INT_ARGB);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private BufferedImage resizeImage(BufferedImage src2, int desiredWidth, int h, int typeIntArgb) {
		
		return null;
	}

	private int getNewHeight(int width, int height, int desiredWidth) {
		double ratio = desiredWidth / (double) width;
		
		return (int) (ratio * height);
	}

	private BufferedImage loadImage(String source) throws IOException {
		BufferedImage img;
		
		img = ImageIO.read(new File(source));
		
		return img;
	}

}
