import platform
from ctypes import CDLL
from importlib.resources import path
import os

arch = platform.machine()
system = platform.system().lower()
extension = None
dependencies = []
package = None

if system == 'linux' and arch == 'x86_64':
    package = 'cardinal_sdk.lib.linuxX64'
    extension = 'so'
elif system == 'darwin' and arch == 'arm64':
    package = 'cardinal_sdk.lib.macosArm64'
    extension = 'dylib'
elif system == 'windows' and arch == 'AMD64':
    package = 'cardinal_sdk.lib.mingwX64'
    extension = 'dll'
else:
    raise Exception(f"Your system ({system} {arch}) is not compatible with this version of the iCure SDK")

for d in dependencies:
    with path(package, d) as d_path:
        CDLL(str(d_path))

with path(package, f"cardinal-sdk.{extension}") as lib_path:
    kdll = CDLL(str(lib_path))
