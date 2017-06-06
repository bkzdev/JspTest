package jsonTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest extends HttpServlet {

	public static void main(String[] args){
		JacksonTest jr = new JacksonTest();

		try {
			System.out.println("Javaオブジェクト→JSON文字列");
			jr.objToStr();
			System.out.println();

			System.out.println("JSON文字列→Javaオブジェクト");
			jr.strToObj();
			System.out.println();

			System.out.println("Javaオブジェクト→JSONファイル");
			jr.objToFile();
			System.out.println();

			System.out.println("JSONファイル→Javaオブジェクト");
			jr.fileToObj();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Javaオブジェクト→JSONファイル
	 * @throws JsonProcessingException
	 */
	private void objToFile() throws JsonProcessingException{
		JsonMaker jm = new JsonMaker();
		jm.id = 100;
		jm.name = "hogefile";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jm);

		try {
		File file = new File("testfile.json");
		FileWriter filewriter;

		filewriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);
		pw.write(json);
		pw.close();
		System.out.println(file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
	 * JSONファイル→Javaオブジェクト
	 * @throws JsonProcessingException
	 */
	private void fileToObj() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		try {

			JsonMaker jm = mapper.readValue(new File("testfile.json"),JsonMaker.class);

			System.out.println(jm);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Javaオブジェクト→JSON文字列
	 * @throws JsonProcessingException
	 */
	private void objToStr() throws JsonProcessingException{
		JsonMaker jm = new JsonMaker();
		jm.id = 10;
		jm.name = "hoge";

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jm);

		System.out.println(json);

	}

	/**
	 * JSON文字列→Javaオブジェクト
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private void strToObj() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"id\":20, \"name\":\"HOGE\"}";

		ObjectMapper mapper = new ObjectMapper();
		JsonMaker jm = mapper.readValue(json, JsonMaker.class);

		System.out.println(jm);

	}

}
