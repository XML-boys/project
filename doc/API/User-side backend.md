
# API Specification for User-side backend

## GET `/users/`

Get list of all available users

## POST `/users/`

Registr new user

## GET `/users/{id}`

Get information about spcific user

## POST `/users/{id}`

Edit user (only logged in user)


## POST `/auth/`

User login


## GET `/agents/` 

Get list of all agents (car renters)

## GET `/agents/{id}`

Get detailed information about specific agent

## POST `/agents/{id}/rate`

Endpoint for rating agent.

## GET `/vehicles/`

Get list of all vehicles in system

## GET `/vehicles/{id}`

Get detailed information for particular vehicle

## POST `/vehicles/{id}/comments`

Endpoint for creating comment for particular vehicle.

## GET `/vehicles/{id}/comments`

Get list of comments for particular vehicle

## GET `/cart`

Get list of vehicles currently in cart for order

## POST `/cart/`

Add vehicle into cart

## POST `/orders/` 

Create order from cart. 


## GET `/orders/`

Get orders for logged in user

