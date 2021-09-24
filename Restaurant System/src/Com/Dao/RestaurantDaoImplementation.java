    package Com.Dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
	import java.util.List;
    import Com.Confrigution.ConnectionFactory;
    import Com.model.Restaurant;

	public  class RestaurantDaoImplementation implements RestaurantDao {

		public RestaurantDaoImplementation() {	 
		}
		
		public List<Restaurant> getAllRestaurants() {
			
			ArrayList<Restaurant> restaurantList = new ArrayList<>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			final String QUERY = "select * from rest";
			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement(QUERY);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next())
				{
					Restaurant restaurant = new Restaurant();
					restaurant.setName(resultSet.getString("name"));
					restaurant.setOtime(resultSet.getInt("otime"));
					restaurant.setCtime(resultSet.getInt("ctime"));
					restaurant.setPhone(resultSet.getInt("phone"));
					restaurant.setAddr(resultSet.getString("addr"));
					restaurant.setCuisine(resultSet.getString("cuisine"));
					restaurantList.add(restaurant);

				}

			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

			return restaurantList;
		}

		@Override
		public int addRestaurant(Com.model.Restaurant rs) {
			System.out.println(rs);
			int status = 0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = ConnectionFactory.getConnection();
				preparedStatement = connection.prepareStatement("insert into rest values(?,?,?,?,?,?)");
				
				
				preparedStatement.setString(1, rs.getName());
				preparedStatement.setInt(2, rs.getOtime());
				preparedStatement.setInt(3, rs.getCtime());
				preparedStatement.setInt(4, rs.getPhone());
				preparedStatement.setString(5, rs.getAddr());
				preparedStatement.setString(6, rs.getCuisine());
				status=preparedStatement.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
					try {
						if(preparedStatement!=null)
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(connection!=null)
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			// TODO Auto-generated method stub
			return status;
		}

		

	}


