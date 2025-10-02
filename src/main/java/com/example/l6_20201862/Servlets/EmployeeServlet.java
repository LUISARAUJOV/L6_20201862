package com.example.l6_20201862.Servlets;

import com.example.l6_20201862.Beans.Employees;
import com.example.l6_20201862.Beans.Jobs;
import com.example.l6_20201862.Daos.DaoEmployee;
import com.example.l6_20201862.Daos.DaoJobs;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;;
import java.util.ArrayList;


@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action") == null ? "home" : request.getParameter("action");

        DaoEmployee daoEmployee = new DaoEmployee();
        DaoJobs daoJobs = new DaoJobs();
        RequestDispatcher rd;

        switch (action) {
            case "home":

                ArrayList<Employees> listaEmpleados = daoEmployee.listarEmpleados();
                request.setAttribute("listaEmpleados", listaEmpleados);

                rd = request.getRequestDispatcher("");
                rd.forward(request, response);
                break;

            case "crear":

                ArrayList<Jobs> listaJobs = daoJobs.listarPuestosDeTrabajo();
                request.setAttribute("listaJobs", listaJobs);

                rd = request.getRequestDispatcher("");
                rd.forward(request, response);
                break;

            case "editar":

                String idStr = request.getParameter("id");
                if (idStr != null) {
                    int employeeId = Integer.parseInt(idStr);
                    Employees empleado = daoEmployee.obtenerEmpleadoPorId(employeeId);
                    ArrayList<Jobs> listaJobsEdit = daoJobs.listarPuestosDeTrabajo();

                    request.setAttribute("empleado", empleado);
                    request.setAttribute("listaJobs", listaJobsEdit);

                    rd = request.getRequestDispatcher("/");
                    rd.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/EmployeeServlet?action=home");
                }
                break;

            case "eliminar":

                String deleteIdStr = request.getParameter("id");
                if (deleteIdStr != null) {
                    int employeeIdDelete = Integer.parseInt(deleteIdStr);
                    daoEmployee.eliminarEmpleado(employeeIdDelete);
                }
                response.sendRedirect(request.getContextPath() + "/EmployeeServlet?action=home");
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/EmployeeServlet?action=home");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        DaoEmployee daoEmployee = new DaoEmployee();

        switch (action) {
            case "guardar":

                String employeeIdStr = request.getParameter("employeeId");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
                String hireDateStr = request.getParameter("hireDate");
                String jobId = request.getParameter("jobId");
                String salaryStr = request.getParameter("salary");
                String commissionPctStr = request.getParameter("commissionPct");
                String managerIdStr = request.getParameter("managerId");
                String departmentIdStr = request.getParameter("departmentId");


                Employees empleado = new Employees();
                empleado.setFirstName(firstName);
                empleado.setLastName(lastName);
                empleado.setEmail(email);
                empleado.setPhoneNumber(phoneNumber);

        }

        }
    }

