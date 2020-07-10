
from ladon.server.wsgi import LadonWSGIApplication
application = LadonWSGIApplication(['ClientProbeService'],['/probe'])
import wsgiref.simple_server


if __name__ == '__main__':
    # Starting the server from command-line will create a stand-alone server on port 8080
    port = 8080
    print("\nServices are running on port %(port)s.\nView browsable API at http://localhost:%(port)s\n" %
          {'port': port})

    server = wsgiref.simple_server.make_server('', port, application)
    server.serve_forever()