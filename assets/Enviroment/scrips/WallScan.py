import os
import re
from collections import defaultdict

directory = 'C:/Users/asv/project/VNMindustry-Mod/assets/Enviroment/Wall'
blocks = defaultdict(list)

pattern = re.compile(r'^(.*?)(\d+)[\s_-](1x1|2x2)\.png$')

for filename in os.listdir(directory):
    match = pattern.match(filename)
    print(filename)
    if match:
        print(filename + "a")
        block_name = match.group(1).strip()
        identifier = match.group(2)
        size = '1' if match.group(3) == '1x1' else '2'
        blocks[block_name].append((identifier, size, filename))

for folder_id, (block_name, files) in enumerate(blocks.items(), start=1):
    block_directory = os.path.join(directory, f"{folder_id}_{block_name}")
    os.makedirs(block_directory, exist_ok=True)
    
    # Đổi tên và di chuyển file
    for identifier in sorted(set(f[0] for f in files)):  # Lặp qua từng số định danh duy nhất
        size_files = [f for f in files if f[0] == identifier]  # Lọc các file có cùng số định danh
        for size_id, (id_, size, filename) in enumerate(size_files, start=1):
            new_filename = f"{folder_id}_{size}{identifier}.png"
            old_path = os.path.join(directory, filename)
            new_path = os.path.join(block_directory, new_filename)
            os.rename(old_path, new_path)

print("Hoàn thành việc gộp và đổi tên file.")
