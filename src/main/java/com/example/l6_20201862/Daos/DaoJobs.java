package com.example.l6_20201862.Daos;

import com.example.l6_20201862.Beans.Jobs;

import java.sql.*;
import java.util.ArrayList;

public class DaoJobs extends DaoBase {

    public ArrayList<Jobs> listarPuestosDeTrabajo() {
        ArrayList<Jobs> lista = new ArrayList<>();

        String sql = "SELECT job_id, job_title, min_salary, max_salary " +
                "FROM jobs " +
                "ORDER BY job_title";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jobs job = new Jobs();
                job.setJobId(rs.getString("job_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setMinSalary(rs.getInt("min_salary"));
                job.setMaxSalary(rs.getInt("max_salary"));
                lista.add(job);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void crearPuestoDeTrabajo(Jobs job) {
        String sql = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, job.getJobId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setInt(3, job.getMinSalary());
            pstmt.setInt(4, job.getMaxSalary());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Jobs obtenerPuestoPorId(String jobId) {
        Jobs job = null;

        String sql = "SELECT job_id, job_title, min_salary, max_salary " +
                "FROM jobs " +
                "WHERE job_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jobId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    job = new Jobs();
                    job.setJobId(rs.getString("job_id"));
                    job.setJobTitle(rs.getString("job_title"));
                    job.setMinSalary(rs.getInt("min_salary"));
                    job.setMaxSalary(rs.getInt("max_salary"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }
}