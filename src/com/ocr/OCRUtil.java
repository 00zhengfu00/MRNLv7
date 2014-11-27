package com.ocr;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.spi.ImageOutputStreamSpi;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;











import com.sun.media.imageio.plugins.tiff.TIFFImageWriteParam;
import com.sun.media.imageioimpl.stream.ChannelImageInputStreamSpi;
import com.sun.media.imageioimpl.stream.ChannelImageOutputStreamSpi;

public class OCRUtil {
	private static final String LANG_OPTION = "-l";
	private static final String EOL = File.separator;
	private static final String IMAGE_FORMAT = "jpg";

	public static String recognizeValidation(InputStream in) throws Exception {
		File tmpFile = File.createTempFile("img", "." + IMAGE_FORMAT);
		OutputStream out = new FileOutputStream(tmpFile);
		IOUtils.copy(in, out);
		IOUtils.closeQuietly(out);
		return format(recognizeText(tmpFile, IMAGE_FORMAT));
	}

	private static String format(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		StringBuffer sb = new StringBuffer(str.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c) || Character.isLetter(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String recognizeText(File imageFile, String imageFormat){
		File tempImage = createImage(imageFile, imageFormat);

		File outputFile = new File(imageFile.getParentFile(), "output");
		StringBuffer strB = new StringBuffer();
		List<String> cmd = new ArrayList<String>();
		String s=SystemUtils.getUserDir().getAbsolutePath()+"\\tesseract\\";//;"C:/Documents and Settings/Administrator/My Documents/Downloads/map/map/tesseract/";
		//cmd.add(SystemUtils.getUserDir() + "/tesseract/tesseract.exe");
		cmd.add(s+"tesseract.exe");
		cmd.add(s+"/tessdata/chi_sim");
		cmd.add(outputFile.getName());
		cmd.add(LANG_OPTION);
		
		cmd.add("chi_sim");
		cmd.add("eng");
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.directory(imageFile.getParentFile());

		cmd.set(1, tempImage.getName());
		pb.command(cmd);
		pb.redirectErrorStream(true);int w =0;
		try{
		Process process = pb.start();

		w= process.waitFor();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// delete temp working files
		tempImage.delete();

		if (w == 0) {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(
						new FileInputStream(outputFile.getAbsolutePath() + ".txt"),
						"utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String str;

			try {
				while ((str = in.readLine()) != null) {
					strB.append(str).append(EOL);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String msg;
			switch (w) {
			case 1:
				msg = "Errors accessing files. There may be spaces in your image's filename.";
				break;
			case 29:
				msg = "Cannot recognize the image or its selected region.";
				break;
			case 31:
				msg = "Unsupported image format.";
				break;
			default:
				msg = "Errors occurred.";
			}
			tempImage.delete();
			throw new RuntimeException(msg);
		}

		new File(outputFile.getAbsolutePath() + ".txt").delete();
		// logger.info("鍥惧儚璇嗗埆缁撴灉:" + strB);
		
		return strB.toString();

	}

	public static File createImage(File imageFile, String imageFormat) {
		File tempFile = null;
		try {
			 // FUCK,客户端加载jar的方式很特殊,所以第三方包注册的serve 无法生效,这里就行动注册了,事儿真多
	        IIORegistry registry = IIORegistry.getDefaultInstance();
	        // registry.registerServiceProvider(new ImageReadWriteSpi(), OperationRegistrySpi.class);//这个,注册不了
	        registry.registerServiceProvider(new ChannelImageInputStreamSpi(), ImageInputStreamSpi.class);
	        registry.registerServiceProvider(new ChannelImageOutputStreamSpi(), ImageOutputStreamSpi.class);
	        // ---------
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.png.CLibPNGImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageReaderCodecLibSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.wbmp.WBMPImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.bmp.BMPImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.pnm.PNMImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.raw.RawImageReaderSpi(), ImageReaderSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi(), ImageReaderSpi.class);
	        //
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg.CLibJPEGImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.png.CLibPNGImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageWriterCodecLibSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.wbmp.WBMPImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.bmp.BMPImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.gif.GIFImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.pnm.PNMImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.raw.RawImageWriterSpi(), ImageWriterSpi.class);
	        registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriterSpi(), ImageWriterSpi.class);
			Iterator<ImageReader> readers = ImageIO
					.getImageReadersByFormatName(imageFormat);
			ImageReader reader = readers.next();

			ImageInputStream iis = ImageIO.createImageInputStream(imageFile);
			reader.setInput(iis);
			// Read the stream metadata
			IIOMetadata streamMetadata = reader.getStreamMetadata();

			// Set up the writeParam
			TIFFImageWriteParam tiffWriteParam = new TIFFImageWriteParam(
					Locale.US);
			tiffWriteParam.setCompressionMode(ImageWriteParam.MODE_DISABLED);

			// Get tif writer and set output to file
			Iterator<ImageWriter> writers = ImageIO
					.getImageWritersByFormatName("tiff");
			ImageWriter writer = writers.next();

			BufferedImage bi = reader.read(0);
			// bi = new ImageFilter(bi).changeGrey();
			IIOImage image = new IIOImage(bi, null, reader.getImageMetadata(0));
			tempFile = tempImageFile(imageFile);
			ImageOutputStream ios = ImageIO.createImageOutputStream(tempFile);
			writer.setOutput(ios);
			writer.write(streamMetadata, image, tiffWriteParam);
			ios.close();

			writer.dispose();
			reader.dispose();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return tempFile;
	}

	private static File tempImageFile(File imageFile) {
		String path = imageFile.getPath();
		StringBuffer strB = new StringBuffer(path);
		strB.insert(path.lastIndexOf('.'), 0);
		return new File(strB.toString().replaceFirst("(?<=\\.)(\\w+)$", "tif"));
	}


}
