package com.sistemas.servlets;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sistemas.model.Measurement;
import com.sistemas.service.MeasurementService;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list-measurements")
public class ListMeasurementServlet extends HttpServlet{
    
    @Autowired
    private MeasurementService measurementService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Measurement> measurements = measurementService.listMeasurements();

        request.setAttribute("measurements", measurements);

        request.getRequestDispatcher("/measurements-list.jsp").forward(request, response);

        
    }
}
