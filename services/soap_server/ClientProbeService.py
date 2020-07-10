from ladon.ladonizer import ladonize
import ladon.interfaces.soap
from ladon.types.ladontype import LadonType

from typing import * 

class GroupStefan(LadonType):
        name = int
        description = int
        numbers = [int]


class ClientProbeService(object):
        @ladonize(rtype=GroupStefan)
        def group(self):
            """
            Fetch the client's remote address
            @rtype: The address
            """
            g = GroupStefan()
            g.name = 7
            g.description = 798
            g.numbers = [1,2,3]
            return g
        
        @ladonize(int, int, rtype=int)
        def add(self, x, y):
                return x+y