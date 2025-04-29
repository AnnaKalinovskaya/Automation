package patterns.facade;

 class DoorFacade {

    private CloseDoor closeDoor;
    private OpenDoor openDoor;
    private LockDoor lockDoor;

     protected DoorFacade(CloseDoor closeDoor, OpenDoor openDoor, LockDoor lockDoor) {
         this.closeDoor = closeDoor;
         this.openDoor = openDoor;
         this.lockDoor = lockDoor;
     }

     protected void closeDoor(){
         closeDoor.close();
     }

     protected void openDoor(){
         openDoor.open();
     }

     protected void lockDoor(){
         lockDoor.lock();
     }


 }
