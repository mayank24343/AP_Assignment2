Download the src Directory

Compilation Instructions

cd src
javac Main.java
java Main

Usage of Collections 

Private ArrayList is used to store the Vehicles, and sort when needed according to Id, Model, Speed or Fuel Efficiency.
Private TreeSet is used to store Vehicles, it ensures that there are no duplicates, and maintains a sorted order according to the Id.

Usage of File I/O 

Buffered Reader is used to read from the required file.
FileWriter is used to write to the required file.
I/O is enclosed in try except finally block to ensure files are closed after use and graceful handling on I/O errors.

Sample Run

Demo Program run showcases save, load, add, remove and sorting features.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    8
    LOAD FLEET
    Enter Filename To Load From:
    fleetdata.csv
    Vehicle ID:AIR009: Maintenance scheduled.
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    6
    GENERATE REPORT

Report Generated:

Total Vehicles: 11
Total Cars: 2
Total Trucks: 2
Total Busses: 2
Total Airplanes: 3
Total Cargo Ships: 2
Average Fuel Efficiency: 7.581818
Total Mileage: 68140.000000
Total Vehicles Needing Maintenance: 1
Total Distinct Models: 8
Fastest Vehicle: AIR009 | Speed: 1500.00
Slowest Vehicle: TRUCK002 | Speed: 60.00
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    1
    ADD VEHICLE
    Vehicle Type:
1. Car
2. Truck
3. Bus
4. Airplane
5. Cargoship
   Enter Vehicle Type Number:
   1
   Would you like to construct:
   1)Default Vehicle
   2)Set Detailed Parameters like fuel level, passenger capacity, cargo capacity etc.
   Enter Choice Number:
   1
   Enter Vehicle ID:
   CAR1947
   Enter Vehicle Model:
   Skoda
   Enter Vehicle Max Speed:
   220
   Enter Vehicle Current Mileage:
   1200
   Enter Vehicle Number of Wheels:
   4
   Vehicle added successfully!

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    6
    GENERATE REPORT

Report Generated:

Total Vehicles: 12
Total Cars: 3
Total Trucks: 2
Total Busses: 2
Total Airplanes: 3
Total Cargo Ships: 2
Average Fuel Efficiency: 8.200000
Total Mileage: 69340.000000
Total Vehicles Needing Maintenance: 1
Total Distinct Models: 9
Fastest Vehicle: AIR009 | Speed: 1500.00
Slowest Vehicle: TRUCK002 | Speed: 60.00
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    1
    ADD VEHICLE
    Vehicle Type:
1. Car
2. Truck
3. Bus
4. Airplane
5. Cargoship
   Enter Vehicle Type Number:
   1
   Would you like to construct:
   1)Default Vehicle
   2)Set Detailed Parameters like fuel level, passenger capacity, cargo capacity etc.
   Enter Choice Number:
   1
   Enter Vehicle ID:
   CAR1947
   Enter Vehicle Model:
   Volvo
   Enter Vehicle Max Speed:
   124
   Enter Vehicle Current Mileage:
   1234
   Enter Vehicle Number of Wheels:
   4
   Vehicle could not be added!
   Error: Exceptions.InvalidOperationException: Vehicle with this ID already exists.

MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    12
    Sorted Fleet By Efficiency: Vehicle ID: SHIP196 | Model: ShipX | Current Mileage: 8730.00 | Maximum Speed: 290.00
    Vehicle ID: SHIP121 | Model: ship | Current Mileage: 8730.00 | Maximum Speed: 200.00
    Vehicle ID: AIR2501 | Model: Airbus A350 | Current Mileage: 20.00 | Maximum Speed: 1000.00
    Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 10.00 | Maximum Speed: 1200.00
    Vehicle ID: AIR009 | Model: AIRBUS A320 | Current Mileage: 20000.00 | Maximum Speed: 1500.00
    Vehicle ID: TRUCK002 | Model: Mahindra | Current Mileage: 8730.00 | Maximum Speed: 60.00
    Vehicle ID: TRUCK010 | Model: Mahindra | Current Mileage: 2000.00 | Maximum Speed: 80.00
    Vehicle ID: BUS1211 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 150.00
    Vehicle ID: BUS101 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 180.00
    Vehicle ID: CAR1411 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 100.00
    Vehicle ID: CAR111 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 120.00
    Vehicle ID: CAR1947 | Model: Skoda | Current Mileage: 1200.00 | Maximum Speed: 220.00
    Fleet Sorted by Efficiency!
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    13
    Sorted Fleet By Id: Vehicle ID: AIR009 | Model: AIRBUS A320 | Current Mileage: 20000.00 | Maximum Speed: 1500.00
    Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 10.00 | Maximum Speed: 1200.00
    Vehicle ID: AIR2501 | Model: Airbus A350 | Current Mileage: 20.00 | Maximum Speed: 1000.00
    Vehicle ID: BUS101 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 180.00
    Vehicle ID: BUS1211 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 150.00
    Vehicle ID: CAR111 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 120.00
    Vehicle ID: CAR1411 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 100.00
    Vehicle ID: CAR1947 | Model: Skoda | Current Mileage: 1200.00 | Maximum Speed: 220.00
    Vehicle ID: SHIP121 | Model: ship | Current Mileage: 8730.00 | Maximum Speed: 200.00
    Vehicle ID: SHIP196 | Model: ShipX | Current Mileage: 8730.00 | Maximum Speed: 290.00
    Vehicle ID: TRUCK002 | Model: Mahindra | Current Mileage: 8730.00 | Maximum Speed: 60.00
    Vehicle ID: TRUCK010 | Model: Mahindra | Current Mileage: 2000.00 | Maximum Speed: 80.00
    Fleet Sorted by Id!
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    14
    Sorted Fleet By Max Speed: Vehicle ID: AIR009 | Model: AIRBUS A320 | Current Mileage: 20000.00 | Maximum Speed: 1500.00
    Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 10.00 | Maximum Speed: 1200.00
    Vehicle ID: AIR2501 | Model: Airbus A350 | Current Mileage: 20.00 | Maximum Speed: 1000.00
    Vehicle ID: TRUCK002 | Model: Mahindra | Current Mileage: 8730.00 | Maximum Speed: 60.00
    Vehicle ID: TRUCK010 | Model: Mahindra | Current Mileage: 2000.00 | Maximum Speed: 80.00
    Vehicle ID: SHIP196 | Model: ShipX | Current Mileage: 8730.00 | Maximum Speed: 290.00
    Vehicle ID: CAR1947 | Model: Skoda | Current Mileage: 1200.00 | Maximum Speed: 220.00
    Vehicle ID: CAR1411 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 100.00
    Vehicle ID: CAR111 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 120.00
    Vehicle ID: BUS1211 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 150.00
    Vehicle ID: BUS101 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 180.00
    Vehicle ID: SHIP121 | Model: ship | Current Mileage: 8730.00 | Maximum Speed: 200.00
    Fleet Sorted by Model!
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    15
    Sorted Fleet By Max Speed: Vehicle ID: TRUCK002 | Model: Mahindra | Current Mileage: 8730.00 | Maximum Speed: 60.00
    Vehicle ID: TRUCK010 | Model: Mahindra | Current Mileage: 2000.00 | Maximum Speed: 80.00
    Vehicle ID: CAR1411 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 100.00
    Vehicle ID: CAR111 | Model: Toyota | Current Mileage: 1230.00 | Maximum Speed: 120.00
    Vehicle ID: BUS1211 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 150.00
    Vehicle ID: BUS101 | Model: Volvo | Current Mileage: 8730.00 | Maximum Speed: 180.00
    Vehicle ID: SHIP121 | Model: ship | Current Mileage: 8730.00 | Maximum Speed: 200.00
    Vehicle ID: CAR1947 | Model: Skoda | Current Mileage: 1200.00 | Maximum Speed: 220.00
    Vehicle ID: SHIP196 | Model: ShipX | Current Mileage: 8730.00 | Maximum Speed: 290.00
    Vehicle ID: AIR2501 | Model: Airbus A350 | Current Mileage: 20.00 | Maximum Speed: 1000.00
    Vehicle ID: AIR111 | Model: AIRBUS A380 | Current Mileage: 10.00 | Maximum Speed: 1200.00
    Vehicle ID: AIR009 | Model: AIRBUS A320 | Current Mileage: 20000.00 | Maximum Speed: 1500.00
    Fleet Sorted by Speed!
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    2
    REMOVING VEHICLE
    Enter Vehicle ID:
    CAR1947
    Removed Vehicle ID: CAR1947
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    6
    GENERATE REPORT

Report Generated:

Total Vehicles: 11
Total Cars: 2
Total Trucks: 2
Total Busses: 2
Total Airplanes: 3
Total Cargo Ships: 2
Average Fuel Efficiency: 7.581818
Total Mileage: 68140.000000
Total Vehicles Needing Maintenance: 1
Total Distinct Models: 8
Fastest Vehicle: AIR009 | Speed: 1500.00
Slowest Vehicle: TRUCK002 | Speed: 60.00
MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    7
    SAVE FLEET
    Enter Filename To Save At:
    savedemo.csv
    Saved Fleet Information to File savedemo.csv
    MENU
1. Add Vehicle
2. Remove Vehicle
3. Start Journey
4. Refuel All
5. Perform Maintenance
6. Generate Report
7. Save Fleet
8. Load Fleet
9. Search by Type
10. List Vehicles Needing Maintenance
11. Fuel Consumption in Journey
12. Sort Fleet by Efficiency
13. Sort Fleet by Id
14. Sort Fleet by Model
15. Sort Fleet by Speed
16. Add Passengers by Vehicle ID
17. Disembark Passengers by Vehicle ID
18. Load Cargo by Vehicle
19. Unload Cargo by Vehicle ID
20. Estimate Journey Time by Vehicle ID
21. Exit
    Please Enter Your Choice Number:
    21
    Program Exited.