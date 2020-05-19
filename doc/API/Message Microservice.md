# API Specification for Message Microservice 

## POST `/conversations`

This is called from order micro service when order is made.

This will create new conversation. 

Parameters: 
* `agent_id`
* `user_id`
* `agent_name`
* `user_name`
* `order_id`


## POST `/conversations{id}/`

Send paticular message 

## GET `/conversations/{id}`

Get messages in particular conversation

## POST `/conversations/{id}/activate`

Order microservice should invoke this endpoint when order for this conversation is actually RESERVED.
