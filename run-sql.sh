# Declare the variable
container_name="my-sql-server"

if [ "$(docker container ls -a -q -f name=$container_name)" == "" ]; then
  # Create new container and database if it doesn't exits
  docker create -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=@ADMINdev2023" -p 1433:1433 --name $container_name -v $(pwd)/sql-data:/var/opt/mssql mcr.microsoft.com/mssql/server:2019-latest
fi

# Check the status of the container
status=$(docker inspect --format "{{.State.Running}}" $container_name)

# If the container is not running, start it
if [ "$status" = "false" ]; then
  docker start $container_name
fi

# Wait for the SQL Server to come up
while true; do
  output=$(docker logs $container_name 2>&1)
  if [[ $output == *"SQL Server is now ready for client connections"* ]]; then
    break
  fi
  sleep 1
done

#Create the database if it doesn't exist
docker exec -it $container_name /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P '@ADMINdev2023' -Q "if((select 1 from sys.databases where name='DBBP_BFSHUB') is null) create database DBBP_BFSHUB"




