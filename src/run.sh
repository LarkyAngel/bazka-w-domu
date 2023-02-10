echo podaj nazwę bazy:
read database
echo podaj username:
read username
echo podaj hasło:
read password

export PGPASSWORD="$password"

FILE=/skijumping/Main.class
if ! [[ -f "$FILE" ]]; then
	psql -d $database -U $username -f tabele.sql
	javac --release 8 -cp ".:postgresql-42.5.3.jar" skijumping/*.java
fi

java -cp ".:postgresql-42.5.3.jar" skijumping.Main $database $username $password