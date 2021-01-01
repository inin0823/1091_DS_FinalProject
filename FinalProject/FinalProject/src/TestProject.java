
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TestProject
 */
@WebServlet("/TestProject")
public class TestProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("keyword")== null) {
			String requestUri = request.getRequestURI();
			request.setAttribute("requestUri", requestUri);
			request.getRequestDispatcher("Search.jsp").forward(request, response);
			return;
		}
		ArrayList<Keyword> travelKey = travelList();
		ScoreList webList = new ScoreList();
		
		//GoogleQuery google = new GoogleQuery(request.getParameter("keyword"));
		String k = java.net.URLEncoder.encode(request.getParameter("keyword"), "UTF-8");
		GoogleQuery google = new GoogleQuery(k);
		Map<String, String> query = google.query();
		Map<Integer, String> summarize = google.content();
		ArrayList<String> titleList = new ArrayList<String>();
		ArrayList<String> urlList = new ArrayList<String>();
		ArrayList<String> contentList = new ArrayList<String>();
		//request.setAttribute("query", s);
		for(Entry<String, String> entry : query.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    titleList.add(key);
		    urlList.add(value);
		}
		titleList.remove(0);
	    urlList.remove(0);
		
		for(Map.Entry<Integer, String> entry : summarize.entrySet()) {
		    String value = entry.getValue();
		    contentList.add(value);
		}
		for (int i=0;i<contentList.size();i++) {
			 String key = titleList.get(i);
			 String value = urlList.get(i);
			 String content = contentList.get(i);
			 String url = value.substring(7);

			 url = url.split("&")[0];
			 url = url.split("%")[0];
			 WebPage web = new WebPage(url,key);
			 web.setContent(content);
			 webList.getLst().add(web);
			 webList.add(web);
			try { 
				 web.setScore(travelKey);
			}catch (FileNotFoundException e) {
				 System.out.println("找不到");
			}catch(NullPointerException e){
				 System.out.println("空值");
			}catch(IllegalStateException e){
				 System.out.println("傳輸問題");
			}
			catch(Exception e) {
				 System.out.println("其他問題");
			}
		}		
		webList.sort(); //排序
		//webList.output();

		String[][] sortedQuery = new String[webList.getLst().size()][3];
		request.setAttribute("sortedQuery", sortedQuery);	
		int count=0;
		for(int j=webList.getLst().size()-1;j>=0;j--) {
			sortedQuery[count][0] = webList.getLst().get(j).getName();
			sortedQuery[count][1] = webList.getLst().get(j).getUrl();
			sortedQuery[count][2] = webList.getLst().get(j).getContent();
			count++;
		}
		request.getRequestDispatcher("googleitem.jsp")
		 .forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	public ArrayList<Keyword> travelList() {
		ArrayList<Keyword> travelKey = new ArrayList<Keyword>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Double> weight = new ArrayList<Double>();
		name.add("旅遊");
		name.add("玩");
		name.add("推薦");
		name.add("懶人包");
		name.add("攻略");
		name.add("部落格");
		name.add("札記");
		name.add("一日遊");
		name.add("親子");
		name.add("約會");
		name.add("背包客");
		weight.add(5.0);
		weight.add(5.0);
		weight.add(10.0);
		weight.add(10.0);
		weight.add(5.0);
		weight.add(5.0);
		weight.add(5.0);
		weight.add(2.0);
		weight.add(2.0);
		weight.add(2.0);
		weight.add(2.0);
		int numOfKeywords = 11;
		for(int i =0;i<numOfKeywords;i++){
			Keyword k = new Keyword(name.get(i), weight.get(i));//store key
			travelKey.add(k);
		}
		return travelKey;
	}

}