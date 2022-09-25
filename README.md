## Projektbeschreibung
In dem Projekt finden Sie eine docker-compose-Datei, die eine Verbindung zur Datenbank herstellt. 

Für Test 1 finden Sie eine data-postgres-Datei, die das Einfügen einiger Personen enthält.

Für Test 2 finden Sie einen Endpunkt im Controller. Wenn Sie den Endpunkt aufrufen, enthält die Antwort eine Liste aller Personen, das Durchschnittsalter, und löscht sie dann aus der Tabelle.

Endpunkt: `GET http://localhost:3000/persons/test2/execute`

Antwort: 
```json
{
  "persons": [{
    "id": 1,
    "name": "Alex",
    "age": 20
    },{
    "id": 2,
    "name": "Emma",
    "age": 30
    },{
    "id": 3,
    "name": "Mario",
    "age": 50
    },{
    "id": 4,
    "name": "Melanie",
    "age": 26
    }],
  "averageAge": 31.5,
  "isPersonsDeleted": true
}
```


## Ports
Der Server läuft auf Port 3000
Postgres-Datenbank läuft auf Port 3001


## Datenbank
Führen Sie `docker-compose up` aus, um postgress db in einem Docker-Container auf Port 3001 zu starten.
