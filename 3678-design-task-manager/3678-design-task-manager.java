class TaskManager {

    class Task {
        int taskID;
        int priority;
        int userId;
        boolean exists;
        Task(int taskID, int priority, int userId) {
            this.taskID = taskID;
            this.priority = priority;
            this.userId = userId;
            exists = true;
        }
        void makeFalse() {
            exists = false;
        }
    }

    Map<Integer, Task> taskIdToNode = new HashMap<>();
    PriorityQueue<Task> pq;


    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b)->a.priority==b.priority?(b.taskID-a.taskID):(b.priority-a.priority));
        // add tasks
        for(List<Integer> l : tasks) {
            Task t = new Task(l.get(1), l.get(2), l.get(0));
            pq.add(t);
            taskIdToNode.put(l.get(1), t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
             Task t = new Task(taskId, priority , userId);
            pq.add(t);
            taskIdToNode.put(taskId, t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task task = taskIdToNode.get(taskId);
        pq.remove(task);
        taskIdToNode.remove(taskId);
        task.priority = newPriority;
        pq.add(task);
        taskIdToNode.put(taskId, task);
        
    }
    
    public void rmv(int taskId) {
        Task task = taskIdToNode.get(taskId);
        task.makeFalse();
        taskIdToNode.remove(taskId);
    }
    
    public int execTop() {
        if(pq.size()==0) return -1;
        while(!pq.isEmpty() && !pq.peek().exists) pq.poll();
        if(pq.size()==0) return -1;
        int ans = pq.peek().userId;
        taskIdToNode.remove(pq.poll().taskID);
        
        return ans;
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