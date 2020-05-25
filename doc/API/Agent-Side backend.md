# Agent-side backend 

Backend service on agent side (other company which rents cars through main application)


## POST `/vehicles`

Add vehicle

## GET `/vehicles`

Get list of vehicles

## GET `/vehicles/{id}`

Get detailed information for particular vehicle

## POST `/vehicles/{id}`

Modify existing vehicle

## POST `/vehicles/{id}/rate`

Rate particular car.

## GET `/users/` 

Get list of all users

## POST `/orders`

Create new order for car 

## GET `/orders/`

Get all orders for a car 

## POST `/orders/{id}`

Modify order 

## GET `/orders/{id}`

Get particular order

## GET `/users`

Get all users

## POST `/users`

Register new user 

## GET `/users/{id}`

Get info about user 

## POST `/users/{id}/`

Modify user 

## GET `/rentVehicles`

Get list of vehicles that user wants to rent

## GET `/nonRentedVehicles`

Get list of vehicles that are not rented yet

## POST `/approveRentVehicles/{id}`

Approve request for renting vehicles

## POST `/rentForFirmsUse/{id}`

Rent a vehicle for firms use

## POST `/priceList/`

Create new priceList

## POST `/discount/`

Create new discount