package by.it.dziomin.jd03_02.crud;

import by.it.dziomin.jd03_02.DBConnector;
import by.it.dziomin.jd03_02.beans.Rents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RentsCRUD {
    public boolean create(Rents rent) {
        try {
            String sql = String.format(
                    "INSERT INTO `dziomin`.`rents` (`id`, `date`, `price`, `isopen`, `users_id`, `cars_id`) " +
                            "VALUES ('%d', '%d', '%f', '%d', '%d', '%d');",
                    rent.getId(),
                    rent.getDate(),
                    rent.getPrice(),
                    rent.isOpen(),
                    rent.getUsersId(),
                    rent.getCarsId());
            int count = DBConnector.getStatement().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = DBConnector.getStatement().getGeneratedKeys();
                if (generatedKeys.next()) {
                    rent.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Rents rent) {
        try {
            String sql = String.format(
                    "UPDATE `rents` SET `date`='%d'," + "`price`='%f'," + "`isopen`='%d'," + "`users_id`='%d'," + "`cars_id`='%d'" +
                            "WHERE `id`='%d' ",
                    rent.getDate(),
                    rent.getPrice(),
                    rent.isOpen(),
                    rent.getUsersId(),
                    rent.getCarsId(),
                    rent.getId());
            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Rents rent) {
        try {
            String sql = String.format(
                    "DELETE FROM `rents` WHERE `id`='%d'",
                    rent.getId());

            return 1 == DBConnector.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Rents read(long id) {
        try {
            String sql = String.format(
                    "SELECT * FROM `rents` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = DBConnector.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                Rents rent = new Rents();
                rent.setId(resultSet.getLong("id"));
                rent.setDate(resultSet.getLong("date"));
                rent.setPrice(resultSet.getDouble("price"));
                rent.setOpen(resultSet.getInt("isopen"));
                rent.setUsersId(resultSet.getLong("users_id"));
                rent.setCarsId(resultSet.getLong("cars_id"));
                return rent;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}