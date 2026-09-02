package com.sistemas.servlets;

import java.io.IOException;

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

@WebServlet("/register-measurement")
public class RegisterMeasurementServlet extends HttpServlet {
    
    @Autowired
    MeasurementService measurementService;

    @Override 
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Integer deviceId = Integer.parseInt(request.getParameter("deviceId"));
            double value = Double.parseDouble(request.getParameter("value"));
            long timeStamp = Long.parseLong(request.getParameter("timeStamp"));

            Measurement measurement = new Measurement(null, timeStamp, value, deviceId);
            boolean success = measurementService.registerMeasurement(measurement);

            if(success){
                response.sendRedirect(request.getContextPath() + "/list-measurements");

            } else {
                request.setAttribute("errorAlert", "Eror al registrar: El dispositivo no existe, el valor está fuera de rango, o ya existe una medida con el mismo timestamp.");
                request.getRequestDispatcher("measurement-form.jsp").forward(request, response);

            }

        } catch (Exception e){
            request.setAttribute("errorAlert", "Datos inválidos en el formulario.");
            request.getRequestDispatcher("/measurement-form.jsp").forward(request, response);
        }
    }
}
