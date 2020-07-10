from ladon.ladonizer import ladonize
import ladon.interfaces.soap
from ladon.types.ladontype import LadonType

from typing import * 

class Group(LadonType):
        cn = str
        name = str
        description = str
        numbers = [int]


class ClientProbeService(object):
        @ladonize(rtype=str)
        def extract_remote_addr(self,**exports):
            """
            Fetch the client's remote address
            @rtype: The address
            """
            return exports['REMOTE_ADDR']
