## GET `/admin/users/`

Get list of all available users

## GET `/admin/users/{id}`

Get information about spcific user

## GET `/admin/vehicles/`

Get list of all vehicles in system

## GET `/admin/vehicles/{id}`

Get detailed information for particular vehicle

## GET `/admin/allAds/`

Get list of all ads.

## GET `/admin/ad/{id}/`

Get specific ad info.

## POST `/admin/editAd/{id}/`

Admin can edit every ad.

## POST `/admin/editVehicle/{id}/`

Admin can edit every vehicle.

## POST `/admin/editUser/{id}/`

Admin can edit every user.

## GET `/admin/registracion/`

Get list of agents,firms and users that waits for admins registracion approval.

## POST `/admin/registracionApprove/`

Approve or decline agent,firm or user registracion.

## POST `/admin/editUserRole/{id}`

Admin can edit users role.

## POST `/admin/banUser/{id}`

Admin can ban user so they are not available to login.

## POST `/admin/acceptUser/{id}`

Admin must accept users registracion.

## POST `/admin/deleteUser/{id}`

Admin can delete user.

## POST `/admin/userPermission/{id}`

Admin can change users permission so he can not comment,vote etc.

## GET `/admin/approveComment/`

Get list of comments that wait for approval.

## GET `/admin/approveVote/`

Get list of votes that wait for approval.

## POST `/admin/approveComment/{id}`

Admin can approve comment.

## POST `/admin/approveVote/{id}`

Admin can approve vote.