package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArticleServlet extends HttpServlet {
    


    private static final Logger logger = LoggerFactory.getLogger(ArticleServlet.class);


    @Override
    public void init() throws ServletException {
      
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/views/article/index.jsp").forward(req, res);

        //    String action = req.getParameter("action");
        //     if (action == null || action.isEmpty()) {
        //         index(req, res);
        //     } else if ("add".equalsIgnoreCase(action)) {
        //         create(req, res);
        //     } else if ("list".equalsIgnoreCase(action)) {
        //       index(req, res);
        //     } else if ("edit".equalsIgnoreCase(action)) {
        //         edit(req,res);
        //     }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
            if ("create".equals(action)) {
                createP(req, res);
            } else if ("update".equals(action)) {
               update(req,res);
            } else if ("delete".equals(action)) {
                delete(req,res);
            }
       
    }

    // GET REQUEST 
    protected void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// req.setAttribute("model", model);
		this.getServletContext().getRequestDispatcher("/views/article/index.jsp").forward(req, res);

	}

    protected void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/views/member/add.jsp").forward(req, res);
	}

    protected void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String memberId = req.getParameter("id");

        
    }

    protected void createP(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  
    }
    protected void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
    }

    protected void update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
     
    }
}
