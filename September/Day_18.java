// 3408. Design Task Manager - Medium

class TaskManager {

    // Maintaina a map taskId -> (userId , priority) add into it
    // also make an entry into heap<taskId,userId,priority> with sorted by priority and taskId desc order
    //  while adding and editing into map , just make an entry into heap
    // When you want to execTop from heap check whether it exists in the map ( valid triplet )

    class Pair{
        int userId;
        int priority;
        public Pair(int u,int p){
            userId = u;
            priority = p;
        }
        public String toString(){
            return "(userId :"+userId+" , priority:"+priority+")";
        }
    }

    class Triplet{
        int taskId;
        int userId;
        int priority;
        public Triplet(int u,int t,int p){
            taskId = t;
            userId = u;
            priority = p;
        }
        public String toString(){
            return "(userId :"+userId+" , taskId :"+taskId+" , priority:"+priority+")";
        }
    }

    public static Map<Integer,Pair> taskMap;
    public static PriorityQueue<Triplet> heap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        heap = new PriorityQueue<>(new Comparator<Triplet>(){
            @Override
            public int compare(Triplet a , Triplet b){
                if(a.priority == b.priority){
                    return b.taskId - a.taskId;
                }
                return b.priority - a.priority;
            }
        });

        for(List<Integer> rec : tasks){
            int userId = rec.get(0);
            int taskId = rec.get(1);
            int priority = rec.get(2);
            taskMap.put(taskId,new Pair(userId,priority));
            heap.add(new Triplet(userId,taskId,priority));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId,new Pair(userId,priority));
        heap.add(new Triplet(userId,taskId,priority));
    }
    
    public void edit(int taskId, int newPriority) {
        int userId = taskMap.get(taskId).userId;
        taskMap.put(taskId,new Pair(userId,newPriority));
        heap.add(new Triplet(userId,taskId,newPriority));
    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while(true){
            if(heap.isEmpty()) return -1;
            if( taskMap.containsKey(heap.peek().taskId) && 
                taskMap.get(heap.peek().taskId).priority == heap.peek().priority && 
                taskMap.get(heap.peek().taskId).userId == heap.peek().userId){
                taskMap.remove(heap.peek().taskId);
                return heap.poll().userId;
            } else {
                heap.poll();
            }
        }
        
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
