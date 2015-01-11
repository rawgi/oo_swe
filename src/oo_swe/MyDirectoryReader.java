package oo_swe;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class MyDirectoryReader {
	
	static List<File> fileList = new ArrayList<File>();
	
	//------Aufgabe 1------
	//bei der 4. methode war mir nicht ganz klar, wozu man noch "startFile" benötigen sollte. Deshalb habe ich es nur mit einer Liste gemacht
	public static List<File> getFileList() throws IOException{
		return getFileList(new File(".").getCanonicalPath());
	}
	
	public static List<File> getFileList(String fileName) throws IOException{
		return getFileList(new File(fileName));
	}
	
	public static List<File> getFileList(File startFile){
		fileList.clear();
		List<File> directoryContent = new ArrayList<File>();
		for(File fileInDirectory: startFile.listFiles()){
			directoryContent.add(fileInDirectory);
		}
		addAllToFileList(directoryContent);
		
		return fileList;
	}
	
	public static List<File> getFileList(File startFile, List<File> result) throws IOException{

		return result;
	}
		
	public static void addAllToFileList(List<File> result){
		for(File file: result){
			if(file.isDirectory()){
				List<File> directoryContent = new ArrayList<File>();
				for(File fileInDirectory: file.listFiles()){
					directoryContent.add(fileInDirectory);
				}
				addAllToFileList(directoryContent);
			}
			fileList.add(file);
		}
	}
	
	//------Aufgabe 2------
	static void convert(String inFile, String outFile, String inEnc, String outEnc) throws Exception{
		String result = "von "+inEnc+" zu "+outEnc+" ";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), inEnc));
		
		int i = in.read();
		while (i>=0){
			char c = (char)i;
			result = result+c;
			i = in.read();
		}
		OutputStream byteOut = new FileOutputStream(outFile);
		
		Writer out = new OutputStreamWriter(byteOut, outEnc);
		out.write(result);
		out.close();
	}
	
	public static void main(String[]args) throws Exception{
//		System.out.println("aktueles verzeichnis");
//		System.out.println(getFileList());
//		System.out.println("projetaufgabe");
//		System.out.println(getFileList("C:/Users/Daniel/git/projektaufgabe"));
		convert("C:/Users/Daniel/test/test.txt","C:/Users/Daniel/test/ausgabe.txt","UTF-8","UTF-16BE");
	}
}
