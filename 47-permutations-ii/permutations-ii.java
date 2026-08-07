class Solution 
{
    public static void solve(int nums[],List<List<Integer>> result,int index)
    {
        if(index==nums.length)
        {
            List<Integer> ans=new ArrayList<>();
            for(int num:nums)
            {
                ans.add(num);
            }
            result.add(ans);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=index;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            {
                continue;
            }
            set.add(nums[i]);

            int temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;

            solve(nums,result,index+1);

            temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        List<List<Integer>> result=new ArrayList<>();
        solve(nums,result,0);
        return result;
    }
}