package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Request;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        String data1 = params.get("data1");
        
        if(data1 == null){
        	render();
        }else{
	        List<String> results = new ArrayList<String>();
	        for(int i=0; i<10; i++){
	        	results.add("data" + i);
	        }
        
        	if(isPjax()){
        		render("/tags/result.html", results);
        	}else{
	        	results.add("directCalled");
        		render(results);
        	}
        }
    }
    
    private static boolean isPjax(){
    	if(params._contains("_pjax")){
    		return true;
		}else if(request.headers.containsKey("X-PJAX")){
    		return true;
    	}else{
    		return false;
    	}
    }

}