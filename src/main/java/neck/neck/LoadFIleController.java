package neck.neck;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoadFIleController {

    @RequestMapping(value = "/loadFile", method = RequestMethod.POST)
    public String loadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String filePath = request.getParameter("processFilePath");
        File file = new File(filePath);
        
        if(file.exists() && !file.isDirectory()){
            Files.write(Paths.get("paths.txt"), (filePath + "\n").getBytes(), StandardOpenOption.APPEND);
        
        String[] filetype = filePath.split("\\.");               
        switch (filetype[1]) {
            case "pcap" : 
                System.out.println("pcap");
                return "pcap";
            case "csv" :
                System.out.println("csv");
                return "csv";
            case "log" :
                System.out.println("log");
                return "log";
    }
        } else {
            request.setAttribute("message", "Path to file is incorrect. Try again.");
            return "loadFile";
        }
        return "loadFile";
    }
}
