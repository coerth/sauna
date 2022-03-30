package dat.startcode.persistence;


import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import dat.startcode.entities.SaunaEvent;
import dat.startcode.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventMapper implements IEventMapper
{

    ConnectionPool connectionPool;

    public EventMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }

    @Override
    public ArrayList<SaunaEvent> getAllEvents() throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        ArrayList<SaunaEvent> eventArrayList = new ArrayList<>();


        try (Connection connection = connectionPool.getConnection())
        {
        String sql ="SELECT * FROM sauna.events_view";
         try(PreparedStatement ps = connection.prepareStatement(sql))
         {
             ResultSet rs = ps.executeQuery();
             while(rs.next())
             {
                int eventID = rs.getInt("event_id");
                String startTime = rs.getString("start_time");
                int duration = rs.getInt("duration");
                int price = rs.getInt("price");
                int participants = rs.getInt("participants");
                String address = rs.getString("address");

                eventArrayList.add(new SaunaEvent(eventID, startTime, duration, price,participants,address));
             }
         }
         catch (SQLException throwables)
         {
             throwables.printStackTrace();
         }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under databaselæsning");
        }

        return eventArrayList;
    }
}
