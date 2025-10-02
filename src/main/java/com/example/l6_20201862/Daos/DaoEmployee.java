package com.example.l6_20201862.Daos;

import com.example.l6_20201862.Beans.Employees;
import com.example.l6_20201862.Beans.Jobs;
import com.example.l6_20201862.Beans.Departments;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployee extends DaoBase {

    public ArrayList<Employees> listarEmpleados() {
        ArrayList<Employees> lista = new ArrayList<>();

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, " +
                "e.phone_number, e.hire_date, e.salary, e.commission_pct, " +
                "j.job_id, j.job_title, " +
                "d.department_id, d.department_name " +
                "FROM employees e " +
                "LEFT JOIN jobs j ON e.job_id = j.job_id " +
                "LEFT JOIN departments d ON e.department_id = d.department_id " +
                "ORDER BY e.employee_id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employees emp = new Employees();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNumber(rs.getString("phone_number"));
                emp.setHireDate(rs.getDate("hire_date"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setCommissionPct(rs.getDouble("commission_pct"));


                Jobs job = new Jobs();
                job.setJobId(rs.getString("job_id"));
                job.setJobTitle(rs.getString("job_title"));
                emp.setJobId(job);


                Departments dept = new Departments();
                dept.setDepartmentId(rs.getInt("department_id"));
                dept.setDepartmentName(rs.getString("department_name"));
                emp.setDepartmentId(dept);

                lista.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }


    public Employees obtenerEmpleadoPorId(int employeeId) {
        Employees emp = null;

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, " +
                "e.phone_number, e.hire_date, e.salary, e.commission_pct, " +
                "j.job_id, j.job_title, j.min_salary, j.max_salary, " +
                "d.department_id, d.department_name, " +
                "m.employee_id as manager_id, m.first_name as manager_first_name, " +
                "m.last_name as manager_last_name " +
                "FROM employees e " +
                "LEFT JOIN jobs j ON e.job_id = j.job_id " +
                "LEFT JOIN departments d ON e.department_id = d.department_id " +
                "LEFT JOIN employees m ON e.manager_id = m.employee_id " +
                "WHERE e.employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    emp = new Employees();
                    emp.setEmployeeId(rs.getInt("employee_id"));
                    emp.setFirstName(rs.getString("first_name"));
                    emp.setLastName(rs.getString("last_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setHireDate(rs.getDate("hire_date"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setCommissionPct(rs.getDouble("commission_pct"));


                    Jobs job = new Jobs();
                    job.setJobId(rs.getString("job_id"));
                    job.setJobTitle(rs.getString("job_title"));
                    job.setMinSalary(rs.getInt("min_salary"));
                    job.setMaxSalary(rs.getInt("max_salary"));
                    emp.setJobId(job);


                    Departments dept = new Departments();
                    dept.setDepartmentId(rs.getInt("department_id"));
                    dept.setDepartmentName(rs.getString("department_name"));
                    emp.setDepartmentId(dept);


                    if (rs.getInt("manager_id") > 0) {
                        Employees manager = new Employees();
                        manager.setEmployeeId(rs.getInt("manager_id"));
                        manager.setFirstName(rs.getString("manager_first_name"));
                        manager.setLastName(rs.getString("manager_last_name"));
                        emp.setManagerId(manager);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }

    public void crearEmpleado(Employees emp) {
        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, " +
                "hire_date, job_id, salary, commission_pct, manager_id, department_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhoneNumber());
            pstmt.setDate(5, new java.sql.Date(emp.getHireDate().getTime()));
            pstmt.setString(6, emp.getJobId() != null ? emp.getJobId().getJobId() : null);
            pstmt.setDouble(7, emp.getSalary());
            pstmt.setDouble(8, emp.getCommissionPct());

            if (emp.getManagerId() != null) {
                pstmt.setInt(9, emp.getManagerId().getEmployeeId());
            } else {
                pstmt.setNull(9, Types.INTEGER);
            }

            if (emp.getDepartmentId() != null) {
                pstmt.setInt(10, emp.getDepartmentId().getDepartmentId());
            } else {
                pstmt.setNull(10, Types.INTEGER);
            }

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void actualizarEmpleado(Employees emp) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, " +
                "phone_number = ?, hire_date = ?, job_id = ?, salary = ?, " +
                "commission_pct = ?, manager_id = ?, department_id = ? " +
                "WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emp.getFirstName());
            pstmt.setString(2, emp.getLastName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhoneNumber());
            pstmt.setDate(5, new java.sql.Date(emp.getHireDate().getTime()));
            pstmt.setString(6, emp.getJobId() != null ? emp.getJobId().getJobId() : null);
            pstmt.setDouble(7, emp.getSalary());
            pstmt.setDouble(8, emp.getCommissionPct());

            if (emp.getManagerId() != null) {
                pstmt.setInt(9, emp.getManagerId().getEmployeeId());
            } else {
                pstmt.setNull(9, Types.INTEGER);
            }

            if (emp.getDepartmentId() != null) {
                pstmt.setInt(10, emp.getDepartmentId().getDepartmentId());
            } else {
                pstmt.setNull(10, Types.INTEGER);
            }

            pstmt.setInt(11, emp.getEmployeeId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarEmpleado(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}