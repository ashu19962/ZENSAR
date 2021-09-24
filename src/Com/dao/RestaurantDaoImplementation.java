package Com.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import Com.Configuration.ConnectionFactory;
	import Com.model.Restaurant;
    import Com.service.RestaurantService;

	public class RestaurantDaoImplementation implements RestaurantDao {
		 ConnectionFactory connectionFactory;
		public RestaurantDaoImplementation() {
			 connectionFactory = new ConnectionFactory();
		}
		@Override
		public List<Restaurant> getAllRestaurants() {
			
			ArrayList<Restaurant> restaurantList = new ArrayList<>();
			//Connection connection = null;
			//PreparedStatement preparedStatement = null;
			//ResultSet resultSet = null;
			final String QUERY = "select * from rest";
			try {
				Connection connection = connectionFactory.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next())
				{
					Restaurant restaurant = new Restaurant();
					restaurant.setName(resultSet.getString(1));
					restaurant.setOtime(resultSet.getInt(2));
					restaurant.setCtime(resultSet.getInt(3));
					restaurant.setPhone(resultSet.getInt(4));
					restaurant.setAddr(resultSet.getString(5));
					restaurant.setCuisine(resultSet.getString(6));
					restaurantList.add(restaurant);

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
			

			return restaurantList;
		}

		public int addRestaurant(Restaurant rs) 
		{
			int status = 0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			try {
				connection = connectionFactory.getConnection();
				preparedStatement = connection.prepareStatement("insert into rest values(?,?,?,?,?,?)");
				preparedStatement.setString(1, rs.getName());
				preparedStatement.setInt(2, rs.getOtime());
				preparedStatement.setInt(3, rs.getCtime());
				preparedStatement.setInt(4, rs.getPhone());
				preparedStatement.setString(5, rs.getAddr());
				preparedStatement.setString(6, rs.getCuisine());
				status=preparedStatement.executeUpdate();
				System.out.println("jii"+status);	
			} catch (Exception e) 
			{
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

		public int deleteRestaurant(String rname) {
			
				   int statusdelete=0;
				  Connection connection=null;
				  PreparedStatement preparedStatment=null;
				  try {
		                     connection=connectionFactory.getConnection();
		                     preparedStatment=connection.prepareStatement("Delete from rest where rname=?");
		                     preparedStatment.setString(1,rname);
		                     statusdelete=preparedStatment.executeUpdate();
				  }catch(SQLException | ClassNotFoundException e)
				  {
					  e.printStackTrace();
				  }finally {
						try {
							if(preparedStatment!=null)
								preparedStatment.close();
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
			return statusdelete;
		
				  }

		public int updateRestaurant(Restaurant rs) 
		{
			int status2=0;
			 Connection connection=null;
			  PreparedStatement preparedStatment=null;
			  try {
				 connection=connectionFactory.getConnection();
				 preparedStatment=connection.prepareStatement("update rest SET rotime=?,rctime=?,rphone=?,raddr=?,rcuisine=? Where rname=?");
				 preparedStatment.setString(6, rs.getName());
				 preparedStatment.setInt(1, rs.getOtime());
				 preparedStatment.setInt(2,rs.getCtime());
				 preparedStatment.setInt(3, rs.getPhone());
				 preparedStatment.setString(4, rs.getAddr());
				 preparedStatment.setString(5, rs.getCuisine());

				 status2=preparedStatment.executeUpdate();
					  
			  }
			  catch(SQLException | ClassNotFoundException e)
			  {
				  e.printStackTrace();
			  }finally {
				  try {
				       if(preparedStatment!=null)
				    	  preparedStatment.close();
				  }
				  catch(SQLException e)
				  {
					  e.printStackTrace();
				  }
				  try
				  {
					   if(connection!=null)
						   connection.close();
				  }
				  catch(SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
	            		
			  return status2;
		}

		@Override
		public Restaurant searchRestaurant(String rs) {
			// TODO Auto-generated method stub
			//ArrayList<Restaurant> restaurantList1 = new ArrayList<>();
			
			  Connection connection=null;
			  PreparedStatement preparedStatment=null;
			  ResultSet resultSet = null;
			  Restaurant restaurant=null;
			  try {
	                    connection=connectionFactory.getConnection();
	                    preparedStatment=connection.prepareStatement("select * from rest where rname=?");
	                    preparedStatment.setString(1, rs);
	                    resultSet = preparedStatment.executeQuery();

	        			while(resultSet.next()){
	        				restaurant = new Restaurant();
	        				restaurant.setName(resultSet.getString(1));
	        				restaurant.setOtime(resultSet.getInt(2));
	        				restaurant.setCtime(resultSet.getInt(3));
	        				restaurant.setPhone(resultSet.getInt(4));
	        				restaurant.setAddr(resultSet.getString(5));
	        				restaurant.setCuisine(resultSet.getString(6));
	        				//restaurantList1.add(restaurant);
	        			}
	        			
	                   // statussearch=preparedStatment.executeUpdate();
	                    System.out.println("ji");
			  }catch(SQLException | ClassNotFoundException e)
			  {
				  e.printStackTrace();
			  }finally {
					try {
						if(preparedStatment!=null)
							preparedStatment.close();
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
		return restaurant;
		}
		
		
		
		}
